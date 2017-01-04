package ac.moim.common.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by SONG_HOHOON on 2016-12-30.
 */
public class StateDto {
	@Data
	public static class Request implements Serializable {
		@NotNull
		private Integer id;
		@NotNull
		private String name;
	}

	@Data
	public static class Response implements Serializable {
		private Integer id;
		private String name;
	}
}
