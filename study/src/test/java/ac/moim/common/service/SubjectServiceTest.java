package ac.moim.common.service;

import ac.moim.common.dto.SubjectDto;
import ac.moim.common.entity.Subject;
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
public class SubjectServiceTest {

	@Autowired
	private SubjectService subjectService;

	private List<SubjectDto.Request> requestList;
	private List<Subject> subjectList;
	private final int subjectCount = 30;

	@Before
	public void setup() {
		requestList = new ArrayList<>();
		subjectList = new ArrayList<>();

		for (int i=0; i < subjectCount; i++) {
			SubjectDto.Request request = new SubjectDto.Request();

			request.setName("test subjcet" + i);
			request.setLevel(1);
			request.setSeq(i);

			requestList.add(request);
		}
	}

	@Test
	public void testGetAllSubject() throws Exception {
		List<Subject> subjects = createTestData();
		List<SubjectDto.Response> responseList = subjectService.getAllSubject();

		assertTrue(subjects.size() == responseList.size());
	}

	@Test
	public void testSaveSubject() throws Exception {
		createTestData();

		for(int i=0; i < subjectCount; i++) {
			assertTrue(subjectList.get(i).getName().equals(requestList.get(i).getName()));
	}
	}

	private List<Subject> createTestData () {
		for (int i=0; i < subjectCount; i++) {
			Subject subject = subjectService.saveSubject(requestList.get(i));
			subjectList.add(subject);
		}

		return subjectList;
	}
}