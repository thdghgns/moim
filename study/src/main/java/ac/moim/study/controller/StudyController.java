package ac.moim.study.controller;

import ac.moim.study.dto.StudyDto;
import ac.moim.study.entity.Study;
import ac.moim.study.exception.StudyBadRequestException;
import ac.moim.study.service.StudyMemberService;
import ac.moim.study.service.StudyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

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

	@RequestMapping(value = "/create-form", method = RequestMethod.GET)
	public String getStudyForm() {
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

		return "views/homeMain";
	}
}
