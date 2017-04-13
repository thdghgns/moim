package ac.moim.study.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ac.moim.study.dto.StudyHistoryDto;
import ac.moim.study.dto.StudyDto.Request;
import ac.moim.study.entity.Study;
import ac.moim.study.entity.StudyHistory;
import ac.moim.study.repository.StudyHistoryRepository;


@Service
public class StudyHistoryServiceImpl implements StudyHistoryService {

	@Autowired
	private StudyHistoryRepository studyHistoryRepository;
	
	@Autowired
	private StudyService studySertvice;

	private StudyHistory toEntity(StudyHistoryDto.Request request) {

		
		StudyHistory studyHistory = new StudyHistory();
		studyHistory.setTitle(request.getTitle());
		studyHistory.setStudyId(studySertvice.findById(request.getStudyId()));
		studyHistory.setContent(request.getContent());

		return studyHistory;
	}
	
	
	@Override
	public List<StudyHistory> findByStudyId(Integer studyId) {
		
		List<StudyHistory> studyHistoryList = studyHistoryRepository.findByStudyId(studyId);
		
		return studyHistoryList;
	}


	@Override
	public void saveStudyHistory(StudyHistoryDto.Request request) {
		StudyHistory studyHistory = studyHistoryRepository.saveAndFlush(toEntity(request));
		
	}
}
