package ac.moim.study.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import ac.moim.common.entity.City;
import ac.moim.common.entity.Subject;
import ac.moim.study.entity.Study;

/**
 * Created by SONG_HOHOON on 2016-12-22.
 */
public interface StudyRepository extends JpaRepository<Study, Integer>, JpaSpecificationExecutor<Study> {
	
	List<Study> findByCityCode(Integer cityCode);
	List<Study> findBySubjectId(Integer SubjectId);
	List<Study> findByInputUserIgnoreCaseContaining(String keyword);
	Page<Study> findByTitleIgnoreCaseContaining(String searchText, Pageable pageRequest);
	Page<Study> findByTitleIgnoreCaseContainingAndSubjectIdAndCityCode(String searchText, int SubjectId, int cityCode, Pageable pageRequest);
	Page<Study> findByTitleIgnoreCaseContainingAndCityCode(String searchText, int cityCode, Pageable pageRequest);
	Page<Study> findByTitleIgnoreCaseContainingAndSubjectId(String searchText, int SubjectId, Pageable pageRequest);
}