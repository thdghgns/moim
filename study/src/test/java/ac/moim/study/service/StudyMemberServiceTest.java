package ac.moim.study.service;

import ac.moim.config.ServiceTestConfiguration;
import ac.moim.study.dto.StudyDto;
import ac.moim.study.dto.StudyMemberDto;
import ac.moim.study.entity.Study;
import ac.moim.study.entity.StudyMember;
import ac.moim.user.dto.UserDto;
import ac.moim.user.entity.User;
import ac.moim.user.service.UserService;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import static junit.framework.Assert.assertTrue;

/**
 * Created by SONG_HOHOON on 2017-01-16.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ServiceTestConfiguration.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Transactional
public class StudyMemberServiceTest {

	@Autowired
	private StudyService studyService;

	@Autowired
	private UserService userService;

	@Autowired
	private StudyMemberService studyMemberService;

	private final int subjectId = 1;
	private final int cityId = 27290;
	private final int memberLimit = 30;
	private Study study;

	@Before
	public void setup() {
		StudyDto.Request request = new StudyDto.Request();
		request.setSubjectId(subjectId);
		request.setCityCode(cityId);
		request.setMemberLimit(memberLimit);
		request.setTitle("test study");
		request.setIntro("test study intro");

		study = studyService.saveStudy(request);
	}

	@Test
	public void testSaveStudyMember() throws Exception {

		for(int i=0; i < memberLimit; i++) {
			User user = createUser(i);

			StudyMemberDto.Request request = new StudyMemberDto.Request();
			request.setStudyId(study.getId());
			request.setUserId(user.getId());
			request.setClassifier("member");

			StudyMember studyMember = studyMemberService.saveStudyMember(request);

			assertTrue(request.getStudyId() == studyMember.getStudy().getId());
			assertTrue(request.getUserId() == studyMember.getUser().getId());
		}
	}

	private User createUser(int id) {
		UserDto.Request user = new UserDto.Request();

		user.setId(String.valueOf(id));
		user.setName("testUser" + id);
		user.setMail("testUser" + id + "@test.mail");

		return userService.saveUser(user);
	}
}