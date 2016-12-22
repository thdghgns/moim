package ac.moim.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ac.moim.user.domain.Member;
import ac.moim.user.domain.MembershipRepository;

@Controller
@RequestMapping("/membership")
public class MembershipController {
//	@Autowired
//	private MembershipService membershipService;
	
	@Autowired
	private MembershipRepository membershipRepository;
	
	@RequestMapping(value = "/enroll", method = RequestMethod.GET)
	public String Enroll() {
//		return membershipService.Enroll("test");
		
		Member newMember = new Member();
		newMember.setUSER_MAIL("tester@eland.co.kr");
		membershipRepository.save(newMember);
		return "success";
	}

}
