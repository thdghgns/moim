package ac.moim.study.service;

import java.util.List;

import ac.moim.common.entity.City;
import ac.moim.study.dto.StudyDto;
import ac.moim.study.entity.Study;

/**
 * Created by SONG_HOHOON on 2016-12-26.
 */
public interface StudyService {

	public void saveStudy(StudyDto.Request study);
	public List<Study> findAll();
	public List<Study> findByCityId(City cityId);
}
