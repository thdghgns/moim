package ac.moim.user.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="MEMBER")
public class Member {
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	private Long USER_ID;
	
	@Id
	@Column(nullable = false, unique = true)
	private String USER_ID;
	
	@Column(nullable = true)
	private String USER_MAIL;
		
	public String getUSER_ID() {
		return USER_ID;
	}

	public void setUSER_ID(String uSER_ID) {
		USER_ID = uSER_ID;
	}

	public String getUSER_MAIL() {
		return USER_MAIL;
	}

	public void setUSER_MAIL(String uSER_MAIL) {
		USER_MAIL = uSER_MAIL;
	}



}
