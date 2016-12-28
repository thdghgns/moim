package ac.moim.study.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by SONG_HOHOON on 2016-12-26.
 */
public class StudyDto {
	@Data
	public static class Request implements Serializable{

		private static final long serialVersionUID = -2230848846689871655L;

		@NotNull
		private String subjectCode;

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
