package ac.moim.common.service;

import ac.moim.common.dto.StateDto;
import ac.moim.common.entity.State;

import java.util.List;

/**
 * Created by SONG_HOHOON on 2016-12-30.
 */
public interface StateService {
	public List<StateDto.Response> getAllState();
	public State saveState(StateDto.Request request);
}
