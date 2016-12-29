package ac.moim.study.service;

import ac.moim.study.dto.StudyDto;
import ac.moim.study.entity.Study;

/**
 * Created by SONG_HOHOON on 2016-12-26.
 */
public interface StudyService {

	public Study saveStudy(StudyDto.Request study);
}
