package ac.moim.dashboard;

//import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.apache.commons.collections.map.MultiValueMap;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import ac.moim.common.interceptor.LoginInterceptor;
import ac.moim.dashboard.controller.NoticeController;
import ac.moim.dashboard.service.NoticeService;
import ac.moim.user.service.UserService;

@RunWith(SpringRunner.class)
@WebMvcTest(NoticeController.class)
@ContextConfiguration(classes={LoginInterceptor.class, NoticeController.class})
public class NoticeApplicationTests {

	@Autowired
	private MockMvc mvc;

	@MockBean
	public NoticeService noticeService;

	@MockBean
	private UserService userService;
	
	private MockHttpServletRequest request;
	private MockHttpServletResponse response;
	private MockHttpSession httpSession;
	
	final static String target = "999";
	
	@Before
	public void setUp() throws Exception {
		// 세션값 지정
		httpSession = new MockHttpSession();
		request = new MockHttpServletRequest();
		response = new MockHttpServletResponse();
		
		httpSession.setAttribute("userid", "101465184090031409556");	
		httpSession.setAttribute("expireTime", "2999-12-31 23:59:59.999");			
	}

	/* GET START */
	@Test
	public void testNoticeMainPage() throws Exception {
		// Main
		this.mvc.perform(get("/notice/main")).andDo(print()).andExpect(status().isOk());

		// Search
		this.mvc.perform(get("/notice/main?searchText=a")).andDo(print()).andExpect(status().isOk());

	}

	/* GET END */

	/* POST Start */

	@Test
	public void testNoticeCreate() throws Exception {
		// Create Page
		this.mvc.perform(get("/notice/create")).andDo(print()).andExpect(status().isOk());

		// Create New Notice
		MultiValueMap params = new MultiValueMap();
		params.put("title", "999");

		this.mvc.perform(post("/notice/create").param("title", "test").param("content", "test")).andDo(print())
				.andExpect(status().isOk());
	}

	@Test
	public void testNoticeUpdate() throws Exception {
		// Detail Page
		this.mvc.perform(get("/notice/detail").param("indexNum", target)).andDo(print()).andExpect(status().isOk());

		// Edit
		this.mvc.perform(post("/notice/edit").param("id", target).param("title", "test")
				.param("content", "testContents").param("hit", "1").param("userName", "tester")).andDo(print())
				.andExpect(status().isOk());
	}

	@Test
	public void testNoticeDelete() throws Exception {
		// Detail Page
		this.mvc.perform(get("/notice/detail").param("indexNum", target)).andDo(print()).andExpect(status().isOk());

		// Delete
		this.mvc.perform(post("/notice/delete").param("id", target)).andDo(print()).andExpect(status().isOk());
	}

	/* POST END */

}
