package ac.moim.common.service;

import ac.moim.common.dto.StateDto;
import ac.moim.common.entity.State;
import ac.moim.config.ServiceTestConfiguration;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by SONG_HOHOON on 2017-01-16.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ServiceTestConfiguration.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Transactional
public class StateServiceTest {

	@Autowired
	private StateService stateService;

	private List<StateDto.Request> requestList;
	private List<State> stateList;
	private final int stateCount = 30;

	@Before
	public void setup() {
		requestList = new ArrayList<>();
		stateList = new ArrayList<>();

		for (int i=0; i < stateCount; i++) {
			StateDto.Request request = new StateDto.Request();
			request.setId(i);
			request.setName("test state" + i);

			requestList.add(request);
		}
	}

	@Test
	public void testGetAllState() throws Exception {
		createTestData();

		List<StateDto.Response> allState = stateService.getAllState();
		assertTrue(allState.size() == stateList.size());
	}

	@Test
	public void testSaveState() throws Exception {
		createTestData();

		for (int i=0; i < stateCount; i++) {
			assertTrue(requestList.get(i).getId().intValue() == stateList.get(i).getCode().intValue());
			assertTrue(requestList.get(i).getName().equals(stateList.get(i).getName()));
		}
	}

	private void createTestData() {
		for (int i=0; i < stateCount; i++) {
			State state = stateService.saveState(requestList.get(i));
			stateList.add(state);
		}
	}
}