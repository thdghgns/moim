package ac.moim.study.service;

import ac.moim.study.dto.StudyMemberDto;

/**
 * Created by SONG_HOHOON on 2016-12-29.
 */
public interface StudyMemberService {
	public void saveStudyMember(StudyMemberDto.Request request);
	public void saveStudyMember(int studyId, String userId);
}
