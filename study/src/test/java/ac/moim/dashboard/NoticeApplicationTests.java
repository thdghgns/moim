package ac.moim.dashboard;

//import static org.assertj.core.api.Assertions.*;
//import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import ac.moim.dashboard.controller.NoticeController;
import ac.moim.dashboard.service.NoticeService;


@RunWith(SpringRunner.class)
//@SpringBootTest
@WebMvcTest(NoticeController.class)
public class NoticeApplicationTests {
	
	@Autowired
    private MockMvc mvc;
	
	@MockBean
	public NoticeService noticeService;
	
	/*GET START*/
	@Test
	public void testNoticeMainPage() throws Exception {
		this.mvc.perform(get("/notice/main"))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(content().contentType("text/html;charset=UTF-8"));		
	}

	@Test
	public void testNoticeDetailPage() throws Exception {
		this.mvc.perform(get("/notice/detail").param("id", "1"))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(content().contentType("text/html;charset=UTF-8"));
	}

	@Test
	public void testNoticeCreatePage() throws Exception {
		this.mvc.perform(get("/notice/create"))
		.andDo(print())
		.andExpect(status().isOk())
	    .andExpect(content().contentType("text/html;charset=UTF-8"));
	}
	
	@Test
	public void testNoticeEditPage() throws Exception {
		this.mvc.perform(get("/notice/edit"))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(content().contentType("text/html;charset=UTF-8"));
	}

    /*GET END*/
	
	/*POST Start*/

//	@RequestMapping(value = "/create", method = RequestMethod.POST)
//	public String NoticeCreate(HttpSession session, Notice notice) {
//		String userName = (String)session.getAttribute("userName");
//		if(userName == null){
//			userName = "unknown";
//		}
//		notice.setInputUser(userName);
//		noticeService.NoticeCreateOrUpdate(notice);
//		return "views/notice/main";
//	}
//	
//	@RequestMapping(value = "/edit", method = RequestMethod.POST)
//	public String NoticeUpdate(Notice notice, String userName) {
//		notice.setInputUser(userName);
//		noticeService.NoticeCreateOrUpdate(notice);
//		return "views/notice/main";
//	}

	@Test
	public void testNoticeDelete() throws Exception {
		this.mvc.perform(post("/notice/delete").param("id", "1"))
		.andDo(print())
		.andExpect(status().isOk());	
	}
	
	/*POST END*/

}
