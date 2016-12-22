package ac.moim.user.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="USER_2")
public class User {
	
	@Id
	@Column(nullable = false, unique = true)
	private String USER_ID;
	
	@Column(nullable = true)
	private String USER_MAIL;

	@Column(nullable = false)
	private String USER_NAME;
	
	@Column(nullable = true)
	private Integer USER_LOCATION_1;
	
	@Column(nullable = true)
	private Integer USER_LOCATION_2;
	
	@Column(nullable = false)
	private Character USER_GENDER;
	
	@Column(nullable = true)
	private Date USER_BIRTHDAY;
	
	@Column(nullable = true)
	private String USER_INTRO;
	
	@Column(nullable = true)
	private Date INDATE_DATE;
	
	@Column(nullable = true)
	private String INUSER_ID;
	
	@Column(nullable = true)
	private Date MODIDATE;
	
	@Column(nullable = true)
	private String MODIUSER_ID;

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

	public String getUSER_NAME() {
		return USER_NAME;
	}

	public void setUSER_NAME(String uSER_NAME) {
		USER_NAME = uSER_NAME;
	}

	public Integer getUSER_LOCATION_1() {
		return USER_LOCATION_1;
	}

	public void setUSER_LOCATION_1(Integer uSER_LOCATION_1) {
		USER_LOCATION_1 = uSER_LOCATION_1;
	}

	public Integer getUSER_LOCATION_2() {
		return USER_LOCATION_2;
	}

	public void setUSER_LOCATION_2(Integer uSER_LOCATION_2) {
		USER_LOCATION_2 = uSER_LOCATION_2;
	}

	public Character getUSER_GENDER() {
		return USER_GENDER;
	}

	public void setUSER_GENDER(Character uSER_GENDER) {
		USER_GENDER = uSER_GENDER;
	}

	public Date getUSER_BIRTHDAY() {
		return USER_BIRTHDAY;
	}

	public void setUSER_BIRTHDAY(Date uSER_BIRTHDAY) {
		USER_BIRTHDAY = uSER_BIRTHDAY;
	}

	public String getUSER_INTRO() {
		return USER_INTRO;
	}

	public void setUSER_INTRO(String uSER_INTRO) {
		USER_INTRO = uSER_INTRO;
	}

	public Date getINDATE_DATE() {
		return INDATE_DATE;
	}

	public void setINDATE_DATE(Date iNDATE_DATE) {
		INDATE_DATE = iNDATE_DATE;
	}

	public String getINUSER_ID() {
		return INUSER_ID;
	}

	public void setINUSER_ID(String iNUSER_ID) {
		INUSER_ID = iNUSER_ID;
	}

	public Date getMODIDATE() {
		return MODIDATE;
	}

	public void setMODIDATE(Date mODIDATE) {
		MODIDATE = mODIDATE;
	}

	public String getMODIUSER_ID() {
		return MODIUSER_ID;
	}

	public void setMODIUSER_ID(String mODIUSER_ID) {
		MODIUSER_ID = mODIUSER_ID;
	}

	
}
