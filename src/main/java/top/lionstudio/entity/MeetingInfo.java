package top.lionstudio.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the zw_meeting_info database table.
 * 
 */
@Entity
@Table(name="zw_meeting_info")
@NamedQuery(name="ZwMeetingInfo.findAll", query="SELECT z FROM MeetingInfo z")
public class MeetingInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String address;

	private String descri;

	private Integer maxnum;

	private String name;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="time_end")
	private Date timeEnd;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="time_signup_end")
	private Date timeSignupEnd;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="time_signup_start")
	private Date timeSignupStart;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="time_start")
	private Date timeStart;

	public MeetingInfo() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDescri() {
		return this.descri;
	}

	public void setDescri(String descri) {
		this.descri = descri;
	}

	public Integer getMaxnum() {
		return this.maxnum;
	}

	public void setMaxnum(int maxnum) {
		this.maxnum = maxnum;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getTimeEnd() {
		return this.timeEnd;
	}

	public void setTimeEnd(Date timeEnd) {
		this.timeEnd = timeEnd;
	}

	public Date getTimeSignupEnd() {
		return this.timeSignupEnd;
	}

	public void setTimeSignupEnd(Date timeSignupEnd) {
		this.timeSignupEnd = timeSignupEnd;
	}

	public Date getTimeSignupStart() {
		return this.timeSignupStart;
	}

	public void setTimeSignupStart(Date timeSignupStart) {
		this.timeSignupStart = timeSignupStart;
	}

	public Date getTimeStart() {
		return this.timeStart;
	}

	public void setTimeStart(Date timeStart) {
		this.timeStart = timeStart;
	}

}