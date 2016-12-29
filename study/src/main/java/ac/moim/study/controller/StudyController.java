package ac.moim.study.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ac.moim.common.entity.City;
import ac.moim.study.dto.StudyDto;
import ac.moim.study.entity.Study;
import ac.moim.study.exception.StudyBadRequestException;
import ac.moim.study.service.StudyService;

/**
 * Created by SONG_HOHOON on 2016-12-26.
 */
@Controller
public class StudyController {

	@Autowired
	private StudyService studyService;

	@RequestMapping(value = "/study", method = RequestMethod.POST)
	public String saveStudy(@RequestBody @Valid StudyDto.Request study, BindingResult result) {

		if (result.hasErrors()) {
			String code = "bad.request";
			String message = "잘못된 요청입니다.";

			throw new StudyBadRequestException(code, message);
		}

		studyService.saveStudy(study);

		return "views/studyMain";
	}
	
	@RequestMapping(value="/studyMain", method = RequestMethod.GET)
	public String studyMain(Model model){
		
		List<Study> studyList;
		studyList = studyService.findAll();
		
		for(int i=0; i<studyList.size(); i++){
			System.out.println(studyList.size());
			System.out.println(studyList.get(i).getTitle());
		}
		
		model.addAttribute("studyList", studyList);
		
		return "views/studyMain";
	}
	
	public String findStudy(Model model, City cityId){
		
		List<Study> studyList;
		studyList = studyService.findByCityId(cityId);
		return null;
	}
}
