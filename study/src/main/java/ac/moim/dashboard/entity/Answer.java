package ac.moim.dashboard.entity;

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
@Table(name = "answer")
public class Answer extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 2453858179253959149L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private Integer questionId;

	@Column(name = "content")
	private String content;
}
