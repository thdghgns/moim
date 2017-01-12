package ac.moim.study.controller;

import ac.moim.StudyApplicationTests;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by SONG_HOHOON on 2017-01-05.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class StudyControllerTest {

	@Autowired
	private TestRestTemplate restTemplate;

	@Before
	public void setup() {
	}

	@Test
	public void testGetStudyForm() throws Exception {
		ResponseEntity<String> entity = restTemplate.getForEntity("/study/create-form", String.class);
		entity.getBody();
		Assert.assertNull(null);
	}

	@Test
	public void testSaveStudy() throws Exception {
		Assert.assertNull(null);
	}

	@Test
	public void testStudyMain() throws Exception {
		Assert.assertNull(null);
	}

	@Test
	public void testFindStudy() throws Exception {
		Assert.assertNull(null);
	}
}