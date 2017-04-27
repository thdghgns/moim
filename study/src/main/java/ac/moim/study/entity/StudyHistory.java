package ac.moim.study.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import ac.moim.common.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Created by KIM_MINJU on 2017-03-21.
 */

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "study_history")
public class StudyHistory extends BaseEntity{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "study_id")
	private Study studyId;
	
	@Column(name = "title")
	private String title;

	@Column(name = "content")
	private String content;
	
	
	
}
