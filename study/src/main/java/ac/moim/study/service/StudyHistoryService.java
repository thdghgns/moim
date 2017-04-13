package ac.moim.study.service;

import java.util.List;

import ac.moim.study.dto.StudyHistoryDto;
import ac.moim.study.entity.StudyHistory;

public interface StudyHistoryService {
	
	public List<StudyHistory> findByStudyId(Integer studyId);
	public void saveStudyHistory(StudyHistoryDto.Request studyHistory);

}
