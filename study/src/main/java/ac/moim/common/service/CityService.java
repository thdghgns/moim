package ac.moim.common.service;

import ac.moim.common.dto.CityDto;
import ac.moim.common.entity.City;

import java.util.List;

/**
 * Created by SONG_HOHOON on 2016-12-30.
 */
public interface CityService {
	public List<CityDto.Response> getAllCity();
	public City saveCity(CityDto.Request request);
}
