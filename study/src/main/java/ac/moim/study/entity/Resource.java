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
@Table(name = "resource")
public class Resource extends BaseEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5586510596467415725L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "study_id")
	private Study studyId;

	@Column(name = "classifier")
	private char classifier;

	@Column(name = "content")
	private String content;

	@Column(name = "hit")
	private int hit = 0;
}
