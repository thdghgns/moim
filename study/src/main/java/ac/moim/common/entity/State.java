package ac.moim.common.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by SONG_HOHOON on 2016-12-22.
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ToString(exclude = {"cityList"})
@Entity
@Table(name = "state")
public class State extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 71622074753189399L;

	@Id
	@Column(name = "code")
	private Integer code;

	@Column(name = "name", nullable = false, unique = true, length = 20)
	private String name;

	@OneToMany(mappedBy = "stateId", fetch = FetchType.EAGER)
	private List<City> cityList;
}
