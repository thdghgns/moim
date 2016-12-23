package ac.moim.user.entity;

import ac.moim.common.entity.BaseEntity;
import ac.moim.common.entity.City;
import ac.moim.study.entity.StudyMember;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by SONG_HOHOON on 2016-12-22.
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "user")
public class User extends BaseEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6289556639755700710L;

	@Id
	@Column(name = "id", unique = true, nullable = false, length = 21)
	private String id;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "mail", unique = true)
	private String mail;

	@ManyToOne
	@JoinColumn(name = "city_id")
	private City cityId;

	@Column(name = "gender")
	private char gender;

	@Column(name = "birthday")
	private Date birthday;

	@Column(name = "intro")
	private String intro;

	@OneToMany(mappedBy = "id.user",fetch = FetchType.LAZY)
	private List<StudyMember> studyMemberList;
}
