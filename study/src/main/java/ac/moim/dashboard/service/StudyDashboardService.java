package ac.moim.dashboard.service;

import ac.moim.dashboard.entity.StudyDashboard;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by thdghgns on 2017. 4. 5..
 */
public interface StudyDashboardService {
    List<StudyDashboard> findAllByStudy(Integer studyId, Pageable pageable);
}
