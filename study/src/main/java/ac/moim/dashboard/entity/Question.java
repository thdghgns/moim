package ac.moim.dashboard.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import ac.moim.common.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Created by SONG_HOHOON on 2016-12-22.
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "question")
public class Question extends BaseEntity implements Serializable {

	/**
	 * 
	 */
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

//	@OneToMany(mappedBy = "questionId", fetch = FetchType.LAZY)
//	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fk.questionId", cascade = { CascadeType.ALL })
//	private Set<Answer> answerList;
}
