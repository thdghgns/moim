package ac.moim.study.entity;

import ac.moim.common.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by SONG_HOHOON on 2016-12-22.
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "comment")
public class Comment extends BaseEntity implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "study_id")
	private Study studyId;

	@Column(name = "content", length = 30)
	private String content;
}
