package ac.moim.dashboard.entity;

import ac.moim.common.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by SONG_HOHOON on 2016-12-22.
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ToString(exclude = "answerList")
@Entity
@Table(name = "question")
public class Question extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 6493879580947679841L;

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
	private Set<Answer> answerList;
}
