package ac.moim.common.service;

import ac.moim.common.dto.CityDto;
import ac.moim.common.dto.StateDto;
import ac.moim.common.entity.State;
import ac.moim.common.utils.EntityLoader;
import ac.moim.config.ServiceTestConfiguration;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by SONG_HOHOON on 2017-01-16.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ServiceTestConfiguration.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Transactional
public class CityServiceTest {

	@Autowired
	private StateService stateService;

	@Autowired
	private CityService cityService;

	private final int stateId = 99;
	private final String stateName = "서울";
	private final int cityCount = 30;

	@Before
	public void setup() {
		StateDto.Request state = new StateDto.Request();

		state.setId(stateId);
		state.setName(stateName);

		stateService.saveState(state);
	}

	@Test
	public void testGetAllCity() throws Exception {

		createTestData();

		List<CityDto.Response> responsesList = cityService.getAllCity();
		assertTrue(responsesList.size() == cityCount);
	}

	private void createTestData() {
		for(int i=0; i<cityCount; i++) {
			CityDto.Request city = new CityDto.Request();

			city.setStateId(stateId);
			city.setCode(i);
			city.setName(stateName + i);

			cityService.saveCity(city);
		}
	}
}