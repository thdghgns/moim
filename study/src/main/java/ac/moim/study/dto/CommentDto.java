package ac.moim.study.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import lombok.Data;

/**
 * Created by LEE_DOYOUNG on 2017-02-19.
 */
public class CommentDto {
	@Data

	public static class Request implements Serializable {
		@NotNull
		private int Id;

		@NotNull
		private String content;

		@NotNull
		private int studyId;
	}

}
