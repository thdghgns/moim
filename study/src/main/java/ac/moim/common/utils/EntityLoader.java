package ac.moim.common.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
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
	StateRepository stateRepository;

	@Autowired
	CityRepository cityRepository;
	
	@Autowired
	StudyRepository studyRepository;

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

			BufferedReader readerState = new BufferedReader(new FileReader(
					"./src/main/resources/address/state/시도.txt"));
			while ((strState = readerState.readLine()) != null) {
				String[] splitState = strState.split("\t");
				stateCode = Integer.valueOf(splitState[0]);
				stateName = splitState[1];
				state.setCode(stateCode);
				state.setName(stateName);
				state.setInputUser("admin");
				stateRepository.save(state);

					BufferedReader readerCity = new BufferedReader(
							new FileReader("./src/main/resources/address/city/"+stateCode+".txt"));
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
			System.exit(1);
		}

	}
	
	
/*	@PostConstruct
	public void testStudyData() {
		Integer id;
		String title;
		String intro;
		int memberCount;
		int memberLimit;
		boolean deleteCheck;
		
		Study study = new Study();
		
		id = 1;
		title = "title1";
		intro = "intro1";
		memberCount = 1;
		memberLimit = 1;
		deleteCheck = true;
		
		study.setId(id);
		study.setTitle(title);
		study.setIntro(intro);
		study.setMemberCount(memberCount);
		study.setMemberLimit(memberLimit);
		study.setDeleteCheck(deleteCheck);
		studyRepository.save(study);
		
		id = 2;
		title = "title2";
		intro = "intro2";
		memberCount = 2;
		memberLimit = 2;
		deleteCheck = true;
		
		study.setId(id);
		study.setTitle(title);
		study.setIntro(intro);
		study.setMemberCount(memberCount);
		study.setMemberLimit(memberLimit);
		study.setDeleteCheck(deleteCheck);
		
		studyRepository.save(study);

	}*/
}
