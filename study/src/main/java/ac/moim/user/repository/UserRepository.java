package ac.moim.user.repository;

import ac.moim.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Created by SONG_HOHOON on 2016-12-22.
 */
public interface UserRepository  extends JpaRepository<User, String>, JpaSpecificationExecutor<User> {
}
