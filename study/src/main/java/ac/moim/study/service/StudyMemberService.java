package ac.moim.study.service;

import ac.moim.study.dto.StudyMemberDto;
import ac.moim.study.entity.StudyMember;

/**
 * Created by SONG_HOHOON on 2016-12-29.
 */
public interface StudyMemberService {
	public StudyMember saveStudyMember(StudyMemberDto.Request request);
	public StudyMember saveStudyMember(int studyId, String userId,String classifier );
}
