package ac.moim.study.controller;

import java.util.ArrayList;
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

import ac.moim.common.service.GmailService;
import ac.moim.study.dto.CommentDto;
import ac.moim.study.dto.StudyMemberDto;
import ac.moim.study.entity.StudyMember;
import ac.moim.study.exception.StudyBadRequestException;
import ac.moim.study.service.CommentService;
import ac.moim.study.service.StudyMemberService;
import ac.moim.study.service.StudyService;
import ac.moim.user.entity.User;
import ac.moim.user.exception.UserNotFoundException;
import ac.moim.user.service.UserService;
//import antlr.collections.List;

/**
 * Created by SONG_HOHOON on 2016-12-29.
 */
@Controller
@RequestMapping(value = "/studyMember")
public class StudyMemberController {

	@Autowired
	private StudyMemberService studyMemberService;
	
	@Autowired
	private StudyService studyService;


	@Autowired
	private CommentService commentService;
	
	@Autowired
	private GmailService gmailService;
	
	@Autowired
	private UserService userService;

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
			@RequestParam(value = "content", required = false, defaultValue = "") String content,
			@RequestParam(value = "userClassifier", required = false, defaultValue = "") String userClassifier) throws Exception {

		StudyMemberDto.Request requestStudyMember = new StudyMemberDto.Request();
		requestStudyMember.setStudyId(studyId);
		
		String userId = (String)httpSession.getAttribute("userId");
		if(userId == null){
			//throw new UserNotFoundException("user.not.found", "사용자를 찾을 수 없습니다. 먼저 로그인하세요.");
		}
			if(userClassifier.equals("leader")){
		
				
			}else if(userClassifier.equals("teamone")){
				studyMemberService.deleteStudyMember(studyId, userId, userClassifier);
				
			}else{				
				
				
				StudyMember studyMember = studyMemberService.saveStudyMember(studyId, userId, "teamone");
				if (studyMember != null) {
					CommentDto.Request requestComment = new CommentDto.Request();
					if (content != null) {
						requestComment.setContent(content);
						requestComment.setStudyId(studyId);
						commentService.saveComment(requestComment);
						StudyMember studyMemberLeader  = studyMemberService.findByStudyIdAndClassifier(studyId, "leader");
			
						List<String> mailList = new ArrayList<String>();		  
						mailList.add(studyMemberLeader.getUser().getMail());
						String subject;
						
						User user = userService.getUser(userId);
						subject = "[MOIM] '"+ studyMemberLeader.getStudy().getTitle() +"'에 새로운 회원" + user.getName() + "님이 가입하였습니다.";
						try {
							gmailService.send(subject, content,mailList);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					}
				}
			}	

			return "views/mypage/myPage";
			}

		


}
