package ac.moim.study.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ac.moim.study.dto.CommentDto;
import ac.moim.study.entity.Comment;
import ac.moim.study.entity.Study;
import ac.moim.study.exception.StudyNotFoundException;
import ac.moim.study.repository.CommentRepository;
import ac.moim.study.repository.StudyRepository;

@Service
public class CommentServiceImpl implements CommentService {
	@Autowired
	private CommentRepository commentRepository;
	@Autowired 	
	private StudyRepository studyRepository;

	
	public Comment saveComment(CommentDto.Request request){
		Comment comment = toEntity(request);		
		return commentRepository.saveAndFlush(comment);
	
	}
	
	private Comment toEntity(CommentDto.Request request){
		Comment comment = new Comment();
		Study study = studyRepository.getOne(request.getStudyId());
		if (study==null)	{
		throw  new StudyNotFoundException();
		}
		
		else{
			comment.setStudyId(study);
			comment.setContent(request.getContent());
		}
		
		return comment;
		
	}

}
