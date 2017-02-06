package ac.moim.common.service;

import java.util.List;

import ac.moim.common.dto.SubjectDto;
import ac.moim.common.entity.Subject;

/**
 * Created by SONG_HOHOON on 2016-12-30.
 */
public interface SubjectService {
	public List<SubjectDto.Response> getAllSubject();
	public Subject saveSubject(SubjectDto.Request request);
	public Subject findById(Integer subjectId);
	public SubjectDto.Response getSubject(Integer subjectId);
}
