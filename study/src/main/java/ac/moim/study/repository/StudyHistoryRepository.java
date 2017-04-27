package ac.moim.study.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import ac.moim.study.entity.StudyHistory;

public interface StudyHistoryRepository extends JpaRepository<StudyHistory, Integer>, JpaSpecificationExecutor<StudyHistory> {

	@Query(value = "select * from study_history where study_history.study_id= ?", nativeQuery = true)
	List<StudyHistory> findByStudyId(Integer studyId);
}

