package ac.moim.dashboard.repository;

import ac.moim.dashboard.entity.StudyDashboard;
import ac.moim.study.entity.Study;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by thdghgns on 2017. 4. 5..
 */
@Repository
public interface StudyDashboardRepository extends JpaRepository<StudyDashboard, Long>, JpaSpecificationExecutor<StudyDashboard> {
    List<StudyDashboard> findByStudy(Study study, Pageable pageable);
}
