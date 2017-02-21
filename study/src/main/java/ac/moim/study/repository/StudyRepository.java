package ac.moim.study.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

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
	Page<Study> findByTitleIgnoreCaseContainingAndSubjectId(String searchText,	int subjectId, Pageable pageRequest);
	Study findById(Integer Id);
	@Query(value = "select * from (select * from study group by study.subject_id, study.id order by study.id desc) as a where a.subject_id = ? limit 3", nativeQuery = true)
	List<Study> findTop3BySubjectStudy(Integer subjectId);

}