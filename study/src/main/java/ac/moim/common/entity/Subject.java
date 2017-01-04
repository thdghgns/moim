package ac.moim.common.entity;

import ac.moim.study.entity.Study;
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
@Table(name = "subject")
public class Subject extends BaseEntity implements Serializable {

	private static final long serialVersionUID = -581904803889835888L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "name", unique = true, nullable = false)
	private String name;

	@Column(name = "parent_id")
	private Integer parentId = 0;

	@Column(name = "level")
	private int level = 1;

	@Column(name = "seq")
	private int seq = 1;

	@Column(name = "delete_check")
	private boolean deleteCheck = false;

	@OneToMany(mappedBy = "subjectId", fetch = FetchType.LAZY)
	private List<Study> studyList;
}
