package top.lionstudio.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the zw_vote_info database table.
 * 
 */
@Entity
@Table(name="zw_vote_info")
@NamedQuery(name="ZwVoteInfo.findAll", query="SELECT z FROM VoteInfo z")
public class VoteInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String descri;

	@Column(name="id_creator")
	private int idCreator;

	@Column(name="id_meeting")
	private int idMeeting;

	private String options;

	private String role;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="time_creat")
	private Date timeCreat;

	private String title;

	public VoteInfo() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescri() {
		return this.descri;
	}

	public void setDescri(String descri) {
		this.descri = descri;
	}

	public int getIdCreator() {
		return this.idCreator;
	}

	public void setIdCreator(int idCreator) {
		this.idCreator = idCreator;
	}

	public int getIdMeeting() {
		return this.idMeeting;
	}

	public void setIdMeeting(int idMeeting) {
		this.idMeeting = idMeeting;
	}

	public String getOptions() {
		return this.options;
	}

	public void setOptions(String options) {
		this.options = options;
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Date getTimeCreat() {
		return this.timeCreat;
	}

	public void setTimeCreat(Date timeCreat) {
		this.timeCreat = timeCreat;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}