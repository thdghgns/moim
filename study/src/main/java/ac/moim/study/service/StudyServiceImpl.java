package ac.moim.study.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import ac.moim.common.entity.City;
import ac.moim.common.entity.Subject;
import ac.moim.common.repository.CityRepository;
import ac.moim.common.repository.SubjectRepository;
import ac.moim.common.service.CityService;
import ac.moim.common.service.SubjectService;
import ac.moim.study.dto.StudyDto;
import ac.moim.study.entity.Study;
import ac.moim.study.repository.StudyRepository;

/**
 * Created by SONG_HOHOON on 2016-12-26.
 */
@Service
public class StudyServiceImpl implements StudyService {

	@Autowired
	private StudyRepository studyRepository;

	@Autowired
	private CityRepository cityRepository;

	@Autowired
	private SubjectRepository subjectRepository;

	@Override
	public Study saveStudy(StudyDto.Request request) {
		Study study = studyRepository.saveAndFlush(toEntity(request));

		return study;
	}

	private Study toEntity(StudyDto.Request request) {

		Study study = new Study();
		study.setTitle(request.getTitle());
		study.setIntro(request.getIntro());
		study.setMemberLimit(request.getMemberLimit());
		study.setCity(cityRepository.findOne(request.getCityCode()));
		study.setSubject(subjectRepository.findOne(request.getSubjectId()));

		return study;
	}

	@Override
	public List<Study> findAll() {

		List<Study> studyList;
		studyList = studyRepository.findAll();

		return studyList;
	}

	@Override
	public List<Study> findBySubjectId(Integer subjectId) {
		List<Study> studyList = studyRepository.findBySubjectId(subjectId);
		return studyList;
	}

	@Override
	public List<Study> findByCityCode(Integer cityCode) {
		List<Study> studyList = studyRepository.findByCityCode(cityCode);

		return studyList;

	}

	@Override
	public List<Study> findByInputUserIgnoreCaseContaining(String keyword) {
		List<Study> studyList = studyRepository 
				.findByInputUserIgnoreCaseContaining(keyword);
		return studyList;
	}

	@Override
	public List<Study> findAll(Integer pageNum, String searchText,
			int subjectId, int cityId) {

		List<Study> studyList;

		Page<Study> studyPage = null;
		try {
			PageRequest pageRequest = new PageRequest(pageNum - 1, 10,
					new Sort(Direction.DESC, "id"));
			studyPage = studyRepository
					.findByTitleIgnoreCaseContainingAndSubjectIdAndCityCode(
							searchText, subjectId, cityId, pageRequest);

			studyList = studyPage.getContent();
		} catch (Exception ex) {
			throw ex;
		}

		return studyList;
	}

	@Override
	public List<Study> findAll(Integer pageNum, String searchText) {

		List<Study> studyList;

		Page<Study> studyPage = null;
		try {
			PageRequest pageRequest = new PageRequest(pageNum - 1, 10,
					new Sort(Direction.DESC, "id"));
			studyPage = studyRepository.findByTitleIgnoreCaseContaining(
					searchText, pageRequest);

			studyList = studyPage.getContent();
		} catch (Exception ex) {
			throw ex;
		}

		return studyList;
	}

	@Override
	public List<Study> findAllBySubjectId(Integer pageNum, String searchText, int subjectId) {
		List<Study> studyList;
		
		Page<Study> studyPage = null;
		try {
			PageRequest pageRequest = new PageRequest(pageNum - 1, 10,
					new Sort(Direction.DESC, "id"));
			studyPage = studyRepository
					.findByTitleIgnoreCaseContainingAndSubjectId(searchText,
							subjectId, pageRequest);

			studyList = studyPage.getContent();
		} catch (Exception ex) {
			throw ex;
		}

		return studyList;
	}
	
	@Override
	public List<Study> findAllByCityCode(Integer pageNum, String searchText, int cityId) {
		List<Study> studyList;
			
		
		Page<Study> studyPage = null;
		try {
			PageRequest pageRequest = new PageRequest(pageNum - 1, 10,
					new Sort(Direction.DESC, "id"));
			studyPage = studyRepository
					.findByTitleIgnoreCaseContainingAndCityCode(searchText,
							cityId, pageRequest);

			studyList = studyPage.getContent();
		} catch (Exception ex) {
			throw ex;
		}

		return studyList;
	}

	@Override
	public List<Study> findTop3BySubjectStudy(Integer subjectId) {
		
		List<Study> studyList;
		
		studyList = studyRepository.findTop3BySubjectStudy(subjectId);
		
		return studyList;
	}
	
}
