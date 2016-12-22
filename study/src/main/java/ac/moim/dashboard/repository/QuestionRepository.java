package ac.moim.dashboard.repository;

import ac.moim.dashboard.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Created by SONG_HOHOON on 2016-12-22.
 */
public interface QuestionRepository extends JpaRepository<Question, Integer>, JpaSpecificationExecutor<Question> {
}
