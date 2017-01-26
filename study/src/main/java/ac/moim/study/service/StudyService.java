package ac.moim.study.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.ui.Model;

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
	public Page<Study> findAll(Pageable pageable);
	public List<Study> findByTitleIgnoreCaseContaining(String keyword);
	public List<Study> findByTitleAndIntroIgnoreCaseContaining(String keyword, String keyword2);
	List<Study> findByInputUserIgnoreCaseContaining(String keyword);
}
