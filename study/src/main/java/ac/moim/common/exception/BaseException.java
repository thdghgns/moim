package ac.moim.common.exception;

import lombok.*;

/**
 * Created by SONG_HOHOON on 2016-12-29.
 */
@Data
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@EqualsAndHashCode(callSuper = false)
public class BaseException extends RuntimeException {
	private String code;
	private String message;
}
