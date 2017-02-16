package ac.moim.common.controller;

import java.util.HashMap;
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
	
	@Autowired
	private StudyService studyService;

	/*@RequestMapping(value = "/", method = RequestMethod.GET)
	public String Index(Model model) {
		return "/views/index";
	}*/
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String Welcome(Model model, @RequestParam(value="name", required=false, defaultValue="World") String name) {

		List<SubjectDto.Response> subjectList = subjectService.getAllSubject();
		HashMap<Integer, List<Study>> studyMap = new HashMap<Integer, List<Study>>();
	
		//List<Study> studyList = studyService.findTop3BySubjectStudy(subjectList.get(1).getId());
		//String subjectName = subjectList.get(1).getName();
		
		//System.out.println(studyList);
		
		for( int i = 0; i < subjectList.size(); i++)
		{
			studyMap.put(subjectList.get(i).getId(), studyService.findTop3BySubjectStudy(subjectList.get(i).getId()));
		}
		
		
/*		for(Response i : subjectList)
		{
			String subjectId = Integer.toString(i.getId()); 
			studyList.put(subjectId, studyService.findTop3BySubjectStudy(i.getId())); 
		}*/
		model.addAttribute("subjectList", subjectList);
		model.addAttribute("studyMap", studyMap);
		model.addAttribute("name", name);
		return "/views/index";
	}	

}
