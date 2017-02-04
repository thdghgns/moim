package ac.moim.study.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import lombok.Data;

import org.hibernate.validator.constraints.Range;

/**
 * Created by SONG_HOHOON on 2016-12-26.
 */
public class StudyDto {
	@Data
	public static class Request implements Serializable{

		@NotNull
		private int subjectId;

		@NotNull
		private String title;

		@NotNull
		private int cityCode;

		@NotNull
		private String intro;
		

		@NotNull
		@Range(min = 1, max = 30)
		private int memberLimit;
	}
}
