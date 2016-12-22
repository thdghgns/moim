package ac.moim.dashboard.entity;

import ac.moim.common.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by SONG_HOHOON on 2016-12-22.
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "question")
public class Question extends BaseEntity implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "title")
	private String title;

	@Column(name = "content")
	private String content;

	@Column(name = "hit")
	private int hit = 0;

	@OneToMany(mappedBy = "questionId", fetch = FetchType.LAZY)
	private List<Answer> answerList;
}
