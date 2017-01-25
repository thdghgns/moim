package ac.moim;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by SONG_HOHOON on 2016-11-17.
 */
@Controller
public class IndexController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String Index(Model model) {
		return "/views/index";
	}
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String Welcome(Model model, @RequestParam(value="name", required=false, defaultValue="World") String name) {

		model.addAttribute("name", name);
		return "/views/index";
	}	

}
