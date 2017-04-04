package ac.moim.study.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ac.moim.common.dto.CityDto;
import ac.moim.common.dto.StateDto;
import ac.moim.common.dto.SubjectDto;
import ac.moim.common.entity.City;
import ac.moim.common.entity.State;
import ac.moim.common.entity.Subject;
import ac.moim.common.service.CityService;
import ac.moim.common.service.StateService;
import ac.moim.common.service.SubjectService;
import ac.moim.study.dto.CommentDto;
import ac.moim.study.dto.StudyDto;
import ac.moim.study.dto.StudyMemberDto;
import ac.moim.study.entity.Study;
import ac.moim.study.entity.StudyMember;
import ac.moim.study.exception.StudyBadRequestException;
import ac.moim.study.service.CommentService;
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
	
	@Autowired
	private CommentService commentService;

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
	public String saveStudy(HttpSession httpSession,
			@RequestBody @Valid StudyDto.Request request, BindingResult result) {

		if (result.hasErrors()) {
			String code = "bad.request";
			String message = "잘못된 요청입니다.";

			throw new StudyBadRequestException(code, message);
		}

		String userId = String.valueOf(httpSession.getAttribute("userId"));
		Study study = studyService.saveStudy(request);

		if (study != null)
			studyMemberService.saveStudyMember(study.getId(), userId,"leader");

		return "views/study/main";
	}

	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String studyMain(
			Model model,
			@RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum,
			@RequestParam(value = "searchText", required = false, defaultValue = "") String searchText,
			@RequestParam(value = "subjectId", required = false) Integer subjectId,
			@RequestParam(value = "cityCode", required = false) Integer cityCode) {

		HashMap<String, Object> results;
		City city = cityService.findByCode(cityCode);
		Subject subject = subjectService.findById(subjectId);
	
		
		if (subjectId == null && cityCode == null) {
			results = studyService.findAll(pageNum, searchText);
		} else if (subjectId == null) {
			results = studyService.findAllByCityCode(pageNum, searchText, city.getCode());
		} else if (cityCode == null) {
			results = studyService.findAllBySubjectId(pageNum, searchText, subject.getId());
		} else {
			results = studyService.findAll(pageNum, searchText, subject.getId(), city.getCode());	
		}

		model.addAttribute("searchText", searchText);
		model.addAttribute("cityCode", cityCode);
		model.addAttribute("subjectId", subjectId);	
		
		List<SubjectDto.Response> subjectList = subjectService.getAllSubject();
		List<StateDto.Response> stateList = stateService.getAllState();
		List<CityDto.Response> cityList = cityService.getAllCity();

		model.addAttribute("cityList", cityList);
		model.addAttribute("stateList", stateList);
		model.addAttribute("subjectList", subjectList);

		model.addAttribute("totalPage", results.get("TotalPage"));
		model.addAttribute("studyList", results.get("StudyList"));
			
		return "views/study/main";
	}
	

	@RequestMapping(value="/detail",method = RequestMethod.GET)
	public String studyDetail(HttpSession httpSession,Model model,@RequestParam(value = "studyId",required = false, defaultValue="" ) int studyId){
		
		
		Study study = studyService.findById(studyId);
		String userId = (String) httpSession.getAttribute("userId");
		if( userId ==null){
			return "redirect:" + "/login";
		}
		
		StudyMember studyMember = studyMemberService.findByUserIdAndStudyId(userId, studyId);
		if( studyMember == null ){
			model.addAttribute("userClassifier","nonmembership");
		}else{
			
				model.addAttribute("userClassifier",studyMember.getClassifier());
		
			
		}
		
		Subject studySubject = study.getSubject();
		City studyCity =study.getCity();
		State studySate=studyCity.getStateId();
		model.addAttribute("study",study);
		model.addAttribute("studySubject",studySubject);
		model.addAttribute("studyCity",studyCity);
		model.addAttribute("studyState",studySate);
		
		return "views/study/detail";
	}
	
}
