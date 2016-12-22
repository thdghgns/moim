package ac.moim.user.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="MEMBER")
public class Member {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long MEMBER_ID;
	
	@Column(nullable = true)
	private Character CHECK_MEMBER;

	public Character getCHECK_MEMBER() {
		return CHECK_MEMBER;
	}

	public void setCHECK_MEMBER(Character cHECK_MEMBER) {
		CHECK_MEMBER = cHECK_MEMBER;
	}

	public Long getMEMBER_ID() {
		return MEMBER_ID;
	}

	public void setMEMBER_ID(Long mEMBER_ID) {
		MEMBER_ID = mEMBER_ID;
	}
	


}
