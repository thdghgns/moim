package ac.moim.common.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by SONG_HOHOON on 2016-12-30.
 */
public class SubjectDto {
	@Data
	public static class Request implements Serializable {
		private Integer id;
		@NotNull
		private String name;
		private Integer parentId = 0;
		@NotNull
		private int level = 1;
		@NotNull
		private int seq = 1;
		private boolean deleteCheck = false;
	}

	@Data
	public static class Response implements Serializable {
		private int id;
		private String name;
		private Integer parentId;
		private int level;
		private int seq;
	}
}
