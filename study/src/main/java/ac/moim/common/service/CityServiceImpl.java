package ac.moim.common.service;

import ac.moim.common.dto.CityDto;
import ac.moim.common.entity.City;
import ac.moim.common.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SONG_HOHOON on 2016-12-30.
 */
@Service
public class CityServiceImpl implements CityService {

	@Autowired
	private CityRepository cityRepository;

	@Override
	public List<CityDto.Response> getAllCity() {

		List<CityDto.Response> responses = new ArrayList<>();

		for(City city : cityRepository.findAll()) {
			responses.add(entityToResponseDto(city));
		}

		return responses;
	}

	private CityDto.Response entityToResponseDto(City city) {
		CityDto.Response response = new CityDto.Response();

		response.setCode(city.getCode());
		response.setName(city.getName());
		response.setStateId(city.getStateId().getCode());

		return response;
	}
}
