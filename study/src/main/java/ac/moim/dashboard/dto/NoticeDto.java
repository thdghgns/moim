package ac.moim.dashboard.dto;

import java.io.Serializable;

import lombok.Data;

public class NoticeDto {
	@Data
	public static class Request implements Serializable {

		private static final long serialVersionUID = 848783555193977648L;

		private Integer id;

		private String title;

		private String content;

		private int hit;
		
		private String userName;

	}
}
