package ac.moim.study.service;

import java.util.HashMap;
import java.util.List;

import ac.moim.study.dto.StudyDto;
import ac.moim.study.entity.Study;

/**
 * Created by SONG_HOHOON on 2016-12-26.
 */
public interface StudyService {
	
	public List<Study> findAll();
	public List<Study> findBySubjectId(Integer subjectId);
	public List<Study> findByCityCode(Integer cityCode);
	public Study saveStudy(StudyDto.Request study);
	public List<Study> findByInputUserIgnoreCaseContaining(String keyword);
	public HashMap<String, Object> findAll(Integer pageNum, String searchText, int subjectId, int cityCode);
	public HashMap<String, Object> findAll(Integer pageNum, String searchText);
	public HashMap<String, Object> findAllBySubjectId(Integer pageNum, String searchText, int subjectId);
	public HashMap<String, Object> findAllByCityCode(Integer pageNum, String searchText, int cityCode);
	public Study findById(int studyId);
	List<Study> findTop3BySubjectStudy(Integer subjectId);

}
