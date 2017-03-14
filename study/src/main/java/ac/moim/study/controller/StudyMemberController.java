package ac.moim.study.controller;

import ac.moim.study.dto.StudyMemberDto;
import ac.moim.study.exception.StudyBadRequestException;
import ac.moim.study.service.StudyMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * Created by SONG_HOHOON on 2016-12-29.
 */
@Controller
public class StudyMemberController {

	@Autowired
	private StudyMemberService studyMemberService;

	@RequestMapping(value = "/study-member", method = RequestMethod.POST)
	public String saveStudyMember(@RequestBody @Valid StudyMemberDto.Request studyMember, BindingResult result) {

		if (result.hasErrors()) {
			String code = "bad.request";
			String message = "잘못된 요청입니다.";

			throw new StudyBadRequestException(code, message);
		}

		
		studyMemberService.saveStudyMember(studyMember);

		return "";
	}
	
	
}
