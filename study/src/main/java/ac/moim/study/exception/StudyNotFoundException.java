package ac.moim.study.exception;

import ac.moim.common.exception.BaseException;

/**
 * Created by SONG_HOHOON on 2016-12-29.
 */
public class StudyNotFoundException extends BaseException {

	public StudyNotFoundException() {
		this.setCode("STUDY_NOT_FOUND");
		this.setMessage("스터디가 존재하지 않습니다.");
	}

	public StudyNotFoundException(String code, String message) {
		super(code, message);
	}
}
