package ac.moim.common.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by SONG_HOHOON on 2016-12-30.
 */
public class CityDto {
	@Data
	 public static class Request implements Serializable {
		@NotNull
		private Integer code;
		@NotNull
		private Integer stateId;
		@NotNull
		private String name;
	}
	@Data
	public static class Response implements Serializable {
		private Integer code;
		private Integer stateId;
		private String name;
	}
}
