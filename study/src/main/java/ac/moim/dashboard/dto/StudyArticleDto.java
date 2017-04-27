package ac.moim.dashboard.dto;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by thdghgns on 2017. 4. 5..
 */
public class StudyArticleDto {
    @Data
    public static class Request implements Serializable{
        @NotNull
        @Min(value = 4)
        @Max(value = 50)
        private String title;

        @NotNull
        @Min(value = 10)
        @Max(value = 500)
        private String content;
    }
}
