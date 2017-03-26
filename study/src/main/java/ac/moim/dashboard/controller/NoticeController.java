package ac.moim.dashboard.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ac.moim.common.service.GmailService;
import ac.moim.dashboard.dto.NoticeDto;
import ac.moim.dashboard.entity.Notice;
import ac.moim.dashboard.service.NoticeService;

@Controller
@RequestMapping("/notice")
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	
	@Autowired
	private GmailService gmailService;
	
	/*Redirect Page*/
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String NoticeMainPage(Model model, 
			@RequestParam(value="pageNum", required=false, defaultValue="1") Integer pageNum, 
			@RequestParam(value="searchText", required=false, defaultValue="") String searchText){	
		HashMap<String, Object> results = noticeService.NoticeMainPage(pageNum, searchText);
		model.addAttribute("totalPage", results.get("TotalPage"));
		model.addAttribute("noticeList", results.get("NoticeList"));
		model.addAttribute("searchText", searchText);
		return "views/notice/main";
	}
	
	@RequestMapping(value = "/detail", method = RequestMethod.GET) 
	public String NoticeDetailPage(Model model,  @RequestParam(value="indexNum", required=true) Integer indexNum) throws Exception{	
		try {
			model.addAttribute("detailList", noticeService.NoticeDetailPage(indexNum));
		} catch (Exception e) {
			throw e;
		}
		return "views/notice/detail";
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String NoticeCreatePage() {
		return "views/notice/create";
	}
	/*Redirect Page*/
	
	
	/*Post*/
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String NoticeCreate(HttpSession session, NoticeDto.Request request) throws Exception{
		String userName = (String)session.getAttribute("userName");
		if(userName == null){
			throw new Exception("NotNullModifyUser");
		}
		
		Notice notice = new Notice();
		notice.setTitle(request.getTitle());
		notice.setContent(request.getContent());
		notice.setInputUser(userName);
		try {
			noticeService.NoticeCreate(notice);
		} catch (Exception e) {
			throw e;
		}
		
		//temp gmail service
		List<String> toMailList = new ArrayList<String>();
		toMailList.add("lim_yungyoo@eland.co.kr");
		
		try {
			gmailService.send("Test Gmail", "Test Message", toMailList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "views/notice/main";
	}
	/*Post*/
	
	/*Put*/
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String NoticeUpdate(HttpSession session, NoticeDto.Request request) throws Exception {
		Boolean result;
		String userName = (String)session.getAttribute("userName");
		if(userName == null){
			throw new Exception("NotNullModifyUser");
		}
		Notice notice = new Notice();
		notice.setId(request.getId());
		notice.setTitle(request.getTitle());
		notice.setContent(request.getContent());
		notice.setHit(request.getHit() - 1);
		notice.setInputUser(userName);
		notice.setModifyUser(userName);
		result = noticeService.NoticeUpdate(notice);
		if(!result){
			throw new Exception("NotEqualInputUser");
		}

		return "views/notice/main";
	}
	/*Put*/
	
		
	/*Delete*/
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String NoticeDelete(HttpSession session, Integer id) throws Exception{
		Boolean result;
		String userName = (String)session.getAttribute("userName");
		if(userName == null){
			throw new Exception("NotNullModifyUser");
		}
		
		result = noticeService.NoticeDelete(id, userName);
		if(!result){
			throw new Exception("NotEqualInputUser");
		}
		return "views/notice/main";
	}
	/*Delete*/
	


}
