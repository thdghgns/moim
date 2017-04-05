package ac.moim.study.service;

import java.util.List;

import ac.moim.study.dto.StudyMemberDto;
import ac.moim.study.entity.Study;
import ac.moim.study.entity.StudyMember;

/**
 * Created by SONG_HOHOON on 2016-12-29.
 */
public interface StudyMemberService {
	public StudyMember saveStudyMember(StudyMemberDto.Request request);
	public StudyMember saveStudyMember(int studyId, String userId,String classifier );
	public StudyMember saveStudyMember(int studyId, String userId);
	public List<Study> findByUserId(String userId);
	public List<Study> findByUserIdAndClassifier(String userId, String classifier);
    public StudyMember findByUserIdAndStudyId(String userId,int studyId);
    public StudyMember findByStudyIdAndClassifier(int studyId, String classifier);
    public void deleteStudyMember(int studyId, String userId, String classifier);



}
