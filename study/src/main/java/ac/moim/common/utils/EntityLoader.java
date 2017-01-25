package ac.moim.common.utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import ac.moim.common.entity.Subject;
import ac.moim.common.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import ac.moim.common.entity.City;
import ac.moim.common.entity.State;
import ac.moim.common.repository.CityRepository;
import ac.moim.common.repository.StateRepository;
import ac.moim.study.entity.Study;
import ac.moim.study.repository.StudyRepository;

/**
 * Created by KIM_MINJU on 2016-12-29.
 */

@Component
public class EntityLoader {

	@Autowired
	ApplicationContext applicationContext;

	@Autowired
	StateRepository stateRepository;

	@Autowired
	CityRepository cityRepository;

	@Autowired
	StudyRepository studyRepository;

	@Autowired
	private SubjectRepository subjectRepository;

	@PostConstruct
	public void initStateCityData() {
		String strState;
		String strCity;
		Integer stateCode;
		String stateName;

		Integer cityCode;
		String cityName;

		State state = new State();
		City city = new City();

		try {
			Resource stateResource = applicationContext.getResource("classpath:address/state/sido.txt");

			BufferedReader readerState = new BufferedReader(new InputStreamReader(stateResource.getInputStream()));
			while ((strState = readerState.readLine()) != null) {
				String[] splitState = strState.split("\t");
				stateCode = Integer.valueOf(splitState[0]);
				stateName = splitState[1];
				state.setCode(stateCode);
				state.setName(stateName);
				state.setInputUser("admin");
				stateRepository.save(state);

				Resource cityResource = applicationContext.getResource("classpath:address/city/"+stateCode+".txt");

				BufferedReader readerCity = new BufferedReader(new InputStreamReader(cityResource.getInputStream()));
				while ((strCity = readerCity.readLine()) != null) {
					String[] splitCity = strCity.split("\t");
					cityCode = Integer.valueOf(splitCity[0]);
					cityName = splitCity[1];
					city.setCode(cityCode);
					city.setName(cityName);
					city.setStateId(state);
					state.setInputUser("admin");
					cityRepository.save(city);
				}
				readerCity.close();
			}
			readerState.close();
		} catch (IOException e) {
			System.out.println(e);
		}

	}

	@PostConstruct
	private void initSubject() {
		String strSubject;

		List<Subject> subjectList = new ArrayList<>();

		BufferedReader readerSubject = null;
		try {
			Resource subjectResource = applicationContext.getResource("classpath:subject/subject.txt");

			readerSubject = new BufferedReader(new InputStreamReader(subjectResource.getInputStream()));

			while ((strSubject = readerSubject.readLine()) != null) {
				Subject subject = new Subject();

				String[] splitState = strSubject.split("\t");
				subject.setName(splitState[0]);
				subject.setParentId(Integer.valueOf(splitState[1]));
				subject.setLevel(Integer.valueOf(splitState[2]));
				subject.setSeq(Integer.valueOf(splitState[3]));
				subject.setDeleteCheck(Boolean.valueOf(splitState[4]));

				subjectList.add(subject);
			}

		} catch (IOException e) {
			System.out.println(e);
		}

		subjectRepository.save(subjectList);
	}
}
