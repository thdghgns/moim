package ac.moim.study.controller;

import ac.moim.study.dto.CommentDto;
import ac.moim.study.dto.StudyMemberDto;
import ac.moim.study.entity.StudyMember;
import ac.moim.study.exception.StudyBadRequestException;
import ac.moim.study.service.CommentService;
import ac.moim.study.service.StudyMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 * Created by SONG_HOHOON on 2016-12-29.
 */
@Controller
@RequestMapping(value = "/studyMember")
public class StudyMemberController {

	@Autowired
	private StudyMemberService studyMemberService;

	@Autowired
	private CommentService commentService;

	@RequestMapping(value = "/study-member", method = RequestMethod.POST)
	public String saveStudyMember(@RequestBody @Valid int studyId, HttpSession httpSession, BindingResult result) {
		StudyMemberDto.Request studyMember = null;
		studyMember.setStudyId(studyId);
		studyMember.setClassifier("teamone");
		String userId = String.valueOf(httpSession.getAttribute("userId"));

		if (userId != null) {
			studyMember.setUserId(userId);
		}

		if (result.hasErrors()) {
			String code = "bad.request";
			String message = "잘못된 요청입니다.";

			throw new StudyBadRequestException(code, message);
		}

		
		studyMemberService.saveStudyMember(studyMember);

		return "";
	}

	@RequestMapping(value = "/enroll", method = RequestMethod.GET)
	public String studyEnroll(Model model, HttpSession httpSession,
			@RequestParam(value = "studyId", required = false, defaultValue = "") Integer studyId,
			@RequestParam(value = "content", required = false, defaultValue = "") String content) {

		StudyMemberDto.Request requestStudyMember = new StudyMemberDto.Request();
		requestStudyMember.setStudyId(studyId);
		if (httpSession.getAttribute("userId") != null) {
			String userId = String.valueOf(httpSession.getAttribute("userId"));
			StudyMember studyMember = studyMemberService.saveStudyMember(studyId, userId, "teamone");

			if (studyMember != null) {
				CommentDto.Request requestComment = new CommentDto.Request();
				if (content != null) {
					requestComment.setContent(content);
					requestComment.setStudyId(studyId);
					commentService.saveComment(requestComment);
				}
			}
			return "views/study/detail";}
		else{
			return "redirect:" + "/login";
		}
		
	}

}
