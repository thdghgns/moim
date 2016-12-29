package ac.moim.study.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by SONG_HOHOON on 2016-12-29.
 */
public class StudyMemberDto {
	@Data
	public static class Request implements Serializable {

		@NotNull
		private int studyId;

		@NotNull
		private String userId;

		@NotNull
		private String classifier;
	}
}
