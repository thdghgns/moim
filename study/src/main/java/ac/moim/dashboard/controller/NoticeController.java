package ac.moim.dashboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/notice")
public class NoticeController {
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String CreatePage() {
		return "views/notice/create";
	}

}
