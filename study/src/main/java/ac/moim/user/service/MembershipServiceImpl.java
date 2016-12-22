package ac.moim.user.service;

import org.springframework.beans.factory.annotation.Autowired;

import ac.moim.user.dao.MembershipDao;

public class MembershipServiceImpl implements MembershipService {
	@Autowired
	private MembershipDao membershipDao;
	
	public Boolean Enroll(String temp){
		return membershipDao.Enroll(temp);
	}
	
}
