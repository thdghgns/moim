package ac.moim.study.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import ac.moim.common.entity.City;
import ac.moim.common.entity.Subject;
import ac.moim.study.entity.Study;

/**
 * Created by SONG_HOHOON on 2016-12-22.
 */
public interface StudyRepository extends JpaRepository<Study, Integer>, JpaSpecificationExecutor<Study> {
	
	List<Study> findByCityId(Integer cityId);
	List<Study> findBySubjectId(Integer SubjectId);
}