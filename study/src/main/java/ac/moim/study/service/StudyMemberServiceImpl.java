package ac.moim.study.service;

import ac.moim.study.dto.StudyMemberDto;
import ac.moim.study.entity.Study;
import ac.moim.study.entity.StudyMember;
import ac.moim.study.exception.StudyNotFoundException;
import ac.moim.study.repository.StudyMemberRepository;
import ac.moim.study.repository.StudyRepository;
import ac.moim.user.entity.User;
import ac.moim.user.exception.UserNotFoundException;
import ac.moim.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public void saveStudyMember(StudyMemberDto.Request request) {

		StudyMember studyMember = toEntity(request.getStudyId(), request.getUserId(), request.getClassifier());

		studyMemberRepository.saveAndFlush(studyMember);
	}

	@Override
	public void saveStudyMember(int studyId, String userId) {
		StudyMember studyMember = toEntity(studyId, userId, "leader");

		studyMemberRepository.saveAndFlush(studyMember);
	}

	private StudyMember toEntity(int studyId, String uesrId, String classifier) {
		StudyMember studyMember = new StudyMember();

		User user = userRepository.findOne(uesrId);
		Study study = studyRepository.findOne(studyId);

		if(user == null)
			throw new UserNotFoundException();
		else if(study == null)
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
}
