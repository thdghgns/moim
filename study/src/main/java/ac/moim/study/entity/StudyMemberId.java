package ac.moim.study.entity;

import ac.moim.user.entity.User;
import lombok.Data;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;

/**
 * Created by SONG_HOHOON on 2016-12-22.
 */
@Data
@Embeddable
public class StudyMemberId implements Serializable {
	private static final long serialVersionUID = -6756338026513941399L;

	@ManyToOne
	private Study study;

	@ManyToOne
	private User user;
}
