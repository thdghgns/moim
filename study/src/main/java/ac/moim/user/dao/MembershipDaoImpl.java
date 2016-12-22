package ac.moim.user.dao;

import org.springframework.beans.factory.annotation.Autowired;

import ac.moim.user.domain.Member;
import ac.moim.user.domain.MembershipRepository;

public class MembershipDaoImpl implements MembershipDao {
	
	@Autowired
	private MembershipRepository membershipRepository;
	
	public Boolean Enroll(String temp){
		Member newMember = new Member();
		Member member = membershipRepository.save(newMember);
		if(member != null){
			return true;
		} else {
			return false;
		}

	}

}
