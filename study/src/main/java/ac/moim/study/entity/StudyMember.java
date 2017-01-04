package ac.moim.study.entity;

import ac.moim.common.entity.BaseEntity;
import ac.moim.user.entity.User;
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
@Table(name = "study_member")
@AssociationOverrides(value = {
	@AssociationOverride(name = "id.study", joinColumns = @JoinColumn(name = "study_id")),
	@AssociationOverride(name = "id.user", joinColumns = @JoinColumn(name = "user_id"))
})
public class StudyMember extends BaseEntity implements Serializable {

	private static final long serialVersionUID = -7173719779454611227L;

	@EmbeddedId
	private StudyMemberId id;

	@Column(name = "classifier")
	private String classifier = "member";

	public StudyMember() {
		this.setId(new StudyMemberId());
	}

	@Transient
	public Study getStudy() {
		return getId().getStudy();
	}

	public void setStudy(Study study) {
		getId().setStudy(study);
	}

	@Transient
	public User getUser() {
		return getId().getUser();
	}

	public void setUser(User user) {
		getId().setUser(user);
	}
}
