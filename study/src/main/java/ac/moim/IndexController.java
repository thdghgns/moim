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

	@RequestMapping(value = "/homeMain", method = RequestMethod.GET)
	public String Welcome(Model model, @RequestParam(value="name", required=false, defaultValue="World") String name) {

		model.addAttribute("name", name);
		return "homeMain";
	}
	
	@RequestMapping(value ="/studyMain", method =RequestMethod.GET)
	public String StudyMain(){
		return "studyMain";
	}
}
