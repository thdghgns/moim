package ac.moim.study.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ac.moim.common.entity.City;
import ac.moim.common.repository.CityRepository;
import ac.moim.common.repository.SubjectRepository;
import ac.moim.study.dto.StudyDto;
import ac.moim.study.dto.StudyMemberDto;
import ac.moim.study.entity.Study;
import ac.moim.study.repository.StudyMemberRepository;
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
		Study study =  studyRepository.saveAndFlush(toEntity(request));

		return study;
	}

	private Study toEntity(StudyDto.Request request) {

		Study study = new Study();
		study.setTitle(request.getTitle());
		study.setIntro(request.getIntro());
		study.setMemberLimit(request.getMemberLimit());
		study.setCityId(cityRepository.findOne(request.getCityCode()));
		study.setSubjectId(subjectRepository.findOne(request.getSubjectId()));

		return study;
	}

	@Override
	public List<Study> findAll() {
		
		List<Study> studyList;
		studyList = studyRepository.findAll();
		
		return studyList;
	}

	@Override
	public List<Study> findByCityId(City cityId) {
		
		List<Study> studyList = studyRepository.findByCityId(cityId);
		
		return studyList;
	}
}
