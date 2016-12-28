package ac.moim.dashboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/Dashboard")
public class NoticeController {
	@RequestMapping(value = "/Create", method = RequestMethod.GET)
	public String CreatePage() {
		return "views/noticeCreate";
	}

}
