package ac.moim.common.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.util.Date;

/**
 * Created by SONG_HOHOON on 2016-12-22.
 */
@Data
@MappedSuperclass
public abstract class BaseEntity {

	@Column(name = "input_user")
	private String inputUser;

	@Column(name = "input_date", nullable = false, insertable = true, updatable = false)
	private Date inputDate;

	@Column(name = "modify_user")
	private String modifyUser;

	@Column(name = "modify_date", nullable = false, insertable = true, updatable = true)
	private Date modifyDate;

	@PrePersist
	void createdAt() {
		this.inputDate = this.modifyDate = new Date();
	}

	@PreUpdate
	void modifyAt() {
		this.modifyDate = new Date();
	}
}
