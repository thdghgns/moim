package ac.moim.study.service;

import ac.moim.study.dto.CommentDto;
import ac.moim.study.entity.Comment;

public interface CommentService {

	public Comment saveComment(CommentDto.Request request);
}
