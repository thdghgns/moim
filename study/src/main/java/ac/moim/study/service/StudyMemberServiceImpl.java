package ac.moim.study.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ac.moim.study.dto.StudyMemberDto;
import ac.moim.study.entity.Study;
import ac.moim.study.entity.StudyMember;
import ac.moim.study.exception.StudyNotFoundException;
import ac.moim.study.repository.StudyMemberRepository;
import ac.moim.study.repository.StudyRepository;
import ac.moim.user.entity.User;
import ac.moim.user.exception.UserNotFoundException;
import ac.moim.user.repository.UserRepository;

/**
 * Created by SONG_HOHOON on 2016-12-29.
 */
@Service
public class StudyMemberServiceImpl implements StudyMemberService {

	@Autowired
	private StudyMemberRepository studyMemberRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private StudyRepository studyRepository;

	@Override
	public StudyMember saveStudyMember(StudyMemberDto.Request request) {

		StudyMember studyMember = toEntity(request.getStudyId(),
				request.getUserId(), request.getClassifier());

		return saveStudyMember(studyMember);
	}

	@Override
	public StudyMember saveStudyMember(int studyId, String userId, String classifier) {
		StudyMember studyMember = toEntity(studyId, userId, classifier);

		return saveStudyMember(studyMember);
	}
	
	public void deleteStudyMember(int studyId, String userId, String classifier){
		StudyMember studyMember = toEntity(studyId, userId, classifier);
		
		deleteStudyMember(studyMember);
	}

	private void deleteStudyMember(StudyMember studyMember) {
		// TODO Auto-generated method stub
		studyMemberRepository.delete(studyMember);
	}
	
	

	private StudyMember saveStudyMember(StudyMember studyMember) {
		return studyMemberRepository.saveAndFlush(studyMember);
	}

	private StudyMember toEntity(int studyId, String uesrId, String classifier) {
		StudyMember studyMember = new StudyMember();

		User user = userRepository.findOne(uesrId);
		Study study = studyRepository.findOne(studyId);

		if (user == null)
			throw new UserNotFoundException();
		else if (study == null)
			throw new StudyNotFoundException();
		else {
			studyMember.setStudy(study);
			studyMember.setUser(user);
			studyMember.setClassifier(classifier);
			studyMember.setInputUser(user.getId());
			studyMember.setModifyUser(user.getId());

			return studyMember;
		}
	}

	@SuppressWarnings("null")
	@Override
	public List<Study> findByUserId(String userId) {

		List<StudyMember> studyMemberList;
		List<Study> studyList = new ArrayList<Study>();
		// Page<StudyMember> studyMemberPage;
		Study study;

		try {
			studyMemberList = studyMemberRepository.findByUserId(userId);

		} catch (Exception ex) {
			throw ex;
		}

		int studyMemberSize = studyMemberList.size();

		for (int i = 0; i < studyMemberSize; i++) {
			study = studyMemberList.get(i).getStudy();
			studyList.add(study);
			System.out.println(studyList);
		}

		return studyList;

	}

	@Override
	public List<Study> findByUserIdAndClassifier(String userId, String classifier) {
		List<StudyMember> studyMemberList;
		List<Study> studyList = new ArrayList<Study>();
		// Page<StudyMember> studyMemberPage;
		Study study;

		try {
			studyMemberList = studyMemberRepository.findByUserIdAndClassifier(userId, classifier);

		} catch (Exception ex) {
			throw ex;
		}

		int studyMemberSize = studyMemberList.size();

		for (int i = 0; i < studyMemberSize; i++) {
			study = studyMemberList.get(i).getStudy();
			studyList.add(study);
			System.out.println(studyList);
		}

		return studyList;
	}
	
	public StudyMember findByUserIdAndStudyId(String userId,int studyId){
		
		StudyMember StudyMember ; 

			StudyMember = studyMemberRepository.findByUserIdAndStudyid(userId,studyId);


		return StudyMember;
	}

	@Override
	public StudyMember saveStudyMember(int studyId, String userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
