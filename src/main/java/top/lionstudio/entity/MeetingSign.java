package top.lionstudio.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the zw_meeting_sign database table.
 * 
 */
@Entity
@Table(name="zw_meeting_sign")
@NamedQuery(name="ZwMeetingSign.findAll", query="SELECT z FROM MeetingSign z")
public class MeetingSign implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String college;

	@Column(name="id_meeting")
	private int idMeeting;

	private String name;

	private String num;

	private String openid;

	private String phonenum;

	private String type;

	public MeetingSign() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCollege() {
		return this.college;
	}

	public void setCollege(String college) {
		this.college = college;
	}

	public int getIdMeeting() {
		return this.idMeeting;
	}

	public void setIdMeeting(int idMeeting) {
		this.idMeeting = idMeeting;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNum() {
		return this.num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getOpenid() {
		return this.openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getPhonenum() {
		return this.phonenum;
	}

	public void setPhonenum(String phonenum) {
		this.phonenum = phonenum;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

}