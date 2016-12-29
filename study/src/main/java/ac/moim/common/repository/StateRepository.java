package ac.moim.common.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import ac.moim.common.entity.City;
import ac.moim.common.entity.State;

/**
 * Created by SONG_HOHOON on 2016-12-22.
 */
public interface StateRepository extends JpaRepository<State, Integer>, JpaSpecificationExecutor<State> {
}
