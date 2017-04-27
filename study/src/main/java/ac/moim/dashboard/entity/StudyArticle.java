package ac.moim.dashboard.entity;

import ac.moim.common.entity.BaseEntity;
import ac.moim.study.entity.Study;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by thdghgns on 2017. 4. 5..
 */
@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@ToString(exclude = "study")
@Table(name = "study_dashboard")
public class StudyArticle extends BaseEntity implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "study_id")
    @JsonIgnore
    private Study study;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @Column(name = "hit")
    private int hit = 0;
}
