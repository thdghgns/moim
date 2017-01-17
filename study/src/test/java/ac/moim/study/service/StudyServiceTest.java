package ac.moim.study.service;

import ac.moim.StudyApplicationTests;
import ac.moim.common.entity.City;
import ac.moim.common.service.CityService;
import ac.moim.config.ServiceTestConfiguration;
import ac.moim.study.dto.StudyDto;
import ac.moim.study.entity.Study;
import org.hamcrest.Matcher;
import org.hamcrest.core.Is;
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
 * Created by SONG_HOHOON on 2017-01-05.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ServiceTestConfiguration.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Transactional
public class StudyServiceTest {

	@Autowired
	private StudyService studyService;

	@Autowired
	private CityService cityService;

	private Study study;
	private List<Study> studyList;
	private StudyDto.Request studyRequest;
	private List<StudyDto.Request> requestList;

	private int studyCount;
	private int cityId;

	@Before
	public void setup() {
		studyList = new ArrayList<>();
		requestList = new ArrayList<>();
		studyCount = 30;
		cityId = 27290;

		String str;
		// create study request object list (30)
		for(int i = 0; i < studyCount; i++) {
			str = "study" + String.valueOf(i);
			studyRequest = new StudyDto.Request();

			studyRequest.setTitle(str);
			studyRequest.setIntro(str);
			studyRequest.setMemberLimit(i);
			studyRequest.setCityCode(cityId);
			studyRequest.setSubjectId(1);

			requestList.add(studyRequest);
		}
	}

	@Test
	public void testSaveStudy() throws Exception {
		createStudyTestData();

		for(int i = 0; i < studyCount; i++) {
			study = studyList.get(i);
			studyRequest = requestList.get(i);

			assertTrue(study.getTitle().equals(studyRequest.getTitle()));
			assertTrue(study.getIntro().equals(studyRequest.getIntro()));
			assertTrue(study.getMemberLimit() == studyRequest.getMemberLimit());
		}
	}

	@Test
	public void testFindAll() throws Exception {
		createStudyTestData();
		List<Study> list = studyService.findAll();

		for(Study i : studyList) {
			assertTrue(list.contains(i));
		}

		assertTrue(list.size() >= studyCount);
	}

	@Test
	public void testFindByCityId() throws Exception {
		createStudyTestData();
		City city = null;//= cityService.
		//List<Study> list = studyService.findByCityId(city);
	}

	private void createStudyTestData() {
		// create study
		for(int i = 0; i < studyCount; i++) {
			studyList.add(studyService.saveStudy(requestList.get(i)));
		}
	}
}