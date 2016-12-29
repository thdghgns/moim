package ac.moim.study.exception;

import ac.moim.common.exception.BaseException;

/**
 * Created by SONG_HOHOON on 2016-12-29.
 */
public class StudyMemberBadRequestException extends BaseException {

	public StudyMemberBadRequestException(String code, String message) {
		super(code, message);
	}
}
