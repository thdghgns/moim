package ac.moim.common.repository;

import ac.moim.common.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Created by SONG_HOHOON on 2016-12-22.
 */
public interface CityRepository extends JpaRepository<City, Integer>, JpaSpecificationExecutor<City> {
	
}
