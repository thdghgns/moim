package ac.moim.dashboard.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ac.moim.dashboard.entity.Notice;
import ac.moim.dashboard.service.NoticeService;

@Controller
@RequestMapping("/notice")
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	
	/*Redirect Page*/
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String NoticeMainPage(Model model,  @RequestParam(value="pageNum", required=false, defaultValue="1") Integer pageNum){	
		HashMap<String, Object> results = noticeService.NoticeMainPage(pageNum);
		model.addAttribute("totalPage", results.get("TotalPage"));
		model.addAttribute("noticeList", results.get("NoticeList"));
		return "views/notice/main";
	}
	
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public String NoticeDetailPage(Model model,  @RequestParam(value="indexNum", required=true) Integer indexNum){	
		model.addAttribute("detailList", noticeService.NoticeDetailPage(indexNum));
		return "views/notice/detail";
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String NoticeCreatePage() {
		return "views/notice/create";
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String NoticeEditPage() {
		return "views/notice/edit";
	}
	/*Redirect Page*/
	
	
	/*Post*/
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String NoticeCreate(Notice notice, String userName) {
		notice.setInputUser(userName);
		noticeService.NoticeCreateOrUpdate(notice);
		return "views/notice/main";
	}
	/*Post*/
	
	/*Put*/
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String NoticeUpdate(Notice notice, String userName) {
		notice.setInputUser(userName);
		noticeService.NoticeCreateOrUpdate(notice);
		return "views/notice/main";
	}
	/*Put*/
	
		
	/*Delete*/
	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	public String NoticeDelete() {
		return "views/notice/main";
	}
	/*Delete*/
	


}
