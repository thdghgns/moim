package ac.moim.common.service;

import ac.moim.common.dto.StateDto;
import ac.moim.common.entity.State;
import ac.moim.common.repository.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SONG_HOHOON on 2016-12-30.
 */
@Service
public class StateServiceImpl implements StateService {

	@Autowired
	private StateRepository stateRepository;

	@Override
	public List<StateDto.Response> getAllState() {

		List<StateDto.Response> stateList = new ArrayList<>();

		for(State state : stateRepository.findAll()) {
			stateList.add(entityToResponseDto(state));
		}

		return stateList;
	}

	private StateDto.Response entityToResponseDto(State state) {
		StateDto.Response response = new StateDto.Response();

		response.setId(state.getCode());
		response.setName(state.getName());

		return response;
	}
}
