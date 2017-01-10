package ac.moim.study.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import ac.moim.common.dto.CityDto;
import ac.moim.common.dto.StateDto;
import ac.moim.common.dto.SubjectDto;
import ac.moim.common.service.CityService;
import ac.moim.common.service.StateService;
import ac.moim.common.service.SubjectService;
import ac.moim.study.dto.StudyDto;
import ac.moim.study.entity.Study;
import ac.moim.study.exception.StudyBadRequestException;
import ac.moim.study.service.StudyMemberService;
import ac.moim.study.service.StudyService;

/**
 * Created by SONG_HOHOON on 2016-12-26.
 */
@Controller

@RequestMapping(value = "/study")
public class StudyController {

	@Autowired
	private StudyService studyService;

	@Autowired
	private StudyMemberService studyMemberService;

	@Autowired
	private SubjectService subjectService;

	@Autowired
	private StateService stateService;

	@Autowired
	private CityService cityService;
	

	@RequestMapping(value = "/create-form", method = RequestMethod.GET)
	public String getStudyForm(Model model) {

		List<SubjectDto.Response> subjectList = subjectService.getAllSubject();
		List<StateDto.Response> stateList = stateService.getAllState();
		List<CityDto.Response> cityList = cityService.getAllCity();

		model.addAttribute("subjectList", subjectList);
		model.addAttribute("stateList", stateList);
		model.addAttribute("cityList", cityList);

		return "views/study/create";
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	public String saveStudy(HttpSession httpSession, @RequestBody @Valid StudyDto.Request request, BindingResult result) {

		if (result.hasErrors()) {
			String code = "bad.request";
			String message = "잘못된 요청입니다.";

			throw new StudyBadRequestException(code, message);
		}

		String userId = String.valueOf(httpSession.getAttribute("userId"));
		Study study = studyService.saveStudy(request);

		if(study != null)
			studyMemberService.saveStudyMember(study.getId(), userId);

		return "views/study/main";
	}
	
	@RequestMapping(value="/main", method = RequestMethod.GET)
	public String studyMain(Model model, @PageableDefault(sort = { "id" }, direction = Direction.DESC, size = 10) Pageable pageable){
	
		Page<Study> studyList = studyService.findAll(pageable);
		List<SubjectDto.Response> subjectList = subjectService.getAllSubject();
		List<StateDto.Response> stateList = stateService.getAllState();
		List<CityDto.Response> cityList = cityService.getAllCity();
		
		model.addAttribute("cityList", cityList);
		model.addAttribute("stateList", stateList);
		model.addAttribute("studyList", studyList);
		model.addAttribute("subjectList", subjectList);
		
		return "views/study/main";
	}
	
	@RequestMapping(value="/select-search", method=RequestMethod.GET)
	@ResponseBody
	public String SelectSearchStudy(@RequestParam(required = false) Integer cityCode
			, @RequestParam(required = false) Integer subjectId){
		studyService.findByCityCode(cityCode);
		studyService.findBySubjectId(subjectId);
		
		return "views/study/main";
	}
}
