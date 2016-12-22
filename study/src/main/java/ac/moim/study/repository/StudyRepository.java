package ac.moim.study.repository;

import ac.moim.study.entity.Study;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Created by SONG_HOHOON on 2016-12-22.
 */
public interface StudyRepository extends JpaRepository<Study, Integer>, JpaSpecificationExecutor<Study> {
}
