package ac.moim.common.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ac.moim.common.dto.SubjectDto;
import ac.moim.common.service.SubjectService;
import ac.moim.study.entity.Study;
import ac.moim.study.service.StudyService;

/**
 * Created by SONG_HOHOON on 2016-11-17.
 */
@Controller
public class IndexController {
	
	@Autowired
	private SubjectService subjectService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String Index(Model model) {
		return "/views/index";
	}
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String Welcome(Model model, @RequestParam(value="name", required=false, defaultValue="World") String name) {

		List<SubjectDto.Response> subjectList = subjectService.getAllSubject();
		String subjectId;
		
		
		for(int i =0; i < subjectList.size(); i++)
		{
			
		}
		
		
		model.addAttribute("subjectList", subjectList);
		model.addAttribute("name", name);
		return "/views/index";
	}	

}
