package ac.moim.study.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import lombok.Data;

public class StudyHistoryDto {
	@Data
	public static class Request implements Serializable{

		@NotNull
		private String content;
		@NotNull
		private Integer studyId;
		@NotNull
		private String title;
		
	}

}
