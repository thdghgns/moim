package ac.moim.study.exception;

import ac.moim.common.exception.BaseException;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by SONG_HOHOON on 2016-12-26.
 */
public class StudyBadRequestException extends BaseException {

	public StudyBadRequestException(String code, String message) {
		super(code, message);
	}
}
