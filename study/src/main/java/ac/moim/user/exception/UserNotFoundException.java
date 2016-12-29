package ac.moim.user.exception;

import ac.moim.common.exception.BaseException;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by SONG_HOHOON on 2016-12-29.
 */
public class UserNotFoundException extends BaseException {

	public UserNotFoundException() {
		this.setCode("USER_NOT_FOUND");
		this.setMessage("사용자가 존재하지 않습니다.");
	}

	public UserNotFoundException(String code, String message) {
		super(code, message);
	}
}
