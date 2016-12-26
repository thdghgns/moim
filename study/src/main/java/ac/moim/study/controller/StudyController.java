package ac.moim.study.controller;

import ac.moim.study.dto.StudyDto;
import ac.moim.study.exception.StudyBadRequestException;
import ac.moim.study.service.StudyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Created by SONG_HOHOON on 2016-12-26.
 */
@RestController
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

		// TODO : study main 화면으로 이동.
		return "";
	}
}
