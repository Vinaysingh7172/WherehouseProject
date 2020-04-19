package in.nit.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="whutab")
public class WHUserType {
	@Id
	@GeneratedValue
	@Column(name="wid")
	private Integer whuId;
	@Column(name="utype")
	private String userType;
	@Column(name="ucode")
	private String userCode;
	@Column(name="ufor")
	private String userFor;
	@Column(name="umail")
	private String userMail;
	@Column(name="ucontact")
	private Long userContact;
	@Column(name="uitype")
	private String userIdType;
	@Column(name="iother")
	private String ifOther;
	@Column(name="inum")
	private String idNumber;
	public WHUserType() {
		super();
	}
	public WHUserType(Integer whuId) {
		super();
		this.whuId = whuId;
	}
	public Integer getWhuId() {
		return whuId;
	}
	public void setWhuId(Integer whuId) {
		this.whuId = whuId;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getUserCode() {
		return userCode;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	public String getUserFor() {
		return userFor;
	}
	public void setUserFor(String userFor) {
		this.userFor = userFor;
	}
	public String getUserMail() {
		return userMail;
	}
	public void setUserMail(String userMail) {
		this.userMail = userMail;
	}
	public Long getUserContact() {
		return userContact;
	}
	public void setUserContact(Long userContact) {
		this.userContact = userContact;
	}
	public String getUserIdType() {
		return userIdType;
	}
	public void setUserIdType(String userIdType) {
		this.userIdType = userIdType;
	}
	public String getIfOther() {
		return ifOther;
	}
	public void setIfOther(String ifOther) {
		this.ifOther = ifOther;
	}
	public String getIdNumber() {
		return idNumber;
	}
	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}
	@Override
	public String toString() {
		return "WHUserType [whuId=" + whuId + ", userType=" + userType + ", userCode=" + userCode + ", userFor="
				+ userFor + ", userMail=" + userMail + ", userContact=" + userContact + ", userIdType=" + userIdType
				+ ", ifOther=" + ifOther + ", idNumber=" + idNumber + "]";
	}
	
}








