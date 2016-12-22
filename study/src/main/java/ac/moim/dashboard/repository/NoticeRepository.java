package ac.moim.dashboard.repository;

import ac.moim.dashboard.entity.Notice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Created by SONG_HOHOON on 2016-12-22.
 */
public interface NoticeRepository extends JpaRepository<Notice, Integer>, JpaSpecificationExecutor<Notice> {
}
