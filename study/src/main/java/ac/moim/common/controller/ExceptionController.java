package ac.moim.common.controller;

import ac.moim.study.exception.StudyBadRequestException;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by SONG_HOHOON on 2016-12-26.
 */
@ControllerAdvice
public class ExceptionController {

	@ExceptionHandler(value = StudyBadRequestException.class)
	@ResponseBody
	@ResponseStatus(value= HttpStatus.BAD_REQUEST)
	public String studyBadRequestExceptionHandler(HttpServletRequest request, HttpServletResponse response, Model model, StudyBadRequestException exception) {

		model.addAttribute("code", exception.getCode());
		model.addAttribute("message", exception.getMessage());

		return "error";
	}
}
