package ac.moim.study.exception;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by SONG_HOHOON on 2016-12-26.
 */
@Data	
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class StudyBadRequestException extends RuntimeException {

	private static final long serialVersionUID = 4054210767807508904L;
	private String code;
	private String message;
}