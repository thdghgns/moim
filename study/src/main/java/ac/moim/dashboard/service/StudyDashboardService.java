package ac.moim.dashboard.service;

import ac.moim.dashboard.entity.StudyArticle;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by thdghgns on 2017. 4. 5..
 */
public interface StudyDashboardService {
    List<StudyArticle> findAllByStudy(Integer studyId, Pageable pageable);
    StudyArticle findOne(Long articleId);
}
