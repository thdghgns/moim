package ac.moim.user.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by SONG_HOHOON on 2016-12-22.
 */
public class UserDto {
	@Data
	public static class Request implements Serializable {
		private static final long serialVersionUID = 6780591412701741764L;
		private String id;
		private String name;
		private String mail;
		private int cityId;
		private String gender;
		private Date birthday;
		private String intro;
	}
	public class Response {

	}
}
