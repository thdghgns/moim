package ac.moim.study.service;

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
	public List<Study> findAll(Integer pageNum, String searchText, int subjectId, int cityCode);
	public List<Study> findAll(Integer pageNum, String searchText);
	public List<Study> findAllBySubjectId(Integer pageNum, String searchText, int subjectId);
	public List<Study> findAllByCityCode(Integer pageNum, String searchText, int cityCode);
	List<Study> findTop3BySubjectStudy(Integer subjectId);
}
