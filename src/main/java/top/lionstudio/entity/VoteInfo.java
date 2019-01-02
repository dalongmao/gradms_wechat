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
	private Integer id;
	private String content;
	private String descri;
	private Integer idCreator;
	private Integer idGroup;
	private String role;
	private Date timeCreat;
	private Date timeEnd;
	private String title;
	private String type;

	public VoteInfo() {
	}


	@Id
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	@Lob
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}


	public String getDescri() {
		return this.descri;
	}

	public void setDescri(String descri) {
		this.descri = descri;
	}


	@Column(name="id_creator")
	public Integer getIdCreator() {
		return this.idCreator;
	}

	public void setIdCreator(Integer idCreator) {
		this.idCreator = idCreator;
	}


	@Column(name="id_group")
	public Integer getIdGroup() {
		return this.idGroup;
	}

	public void setIdGroup(Integer idGroup) {
		this.idGroup = idGroup;
	}


	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}


	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="time_creat")
	public Date getTimeCreat() {
		return this.timeCreat;
	}

	public void setTimeCreat(Date timeCreat) {
		this.timeCreat = timeCreat;
	}


	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="time_end")
	public Date getTimeEnd() {
		return this.timeEnd;
	}

	public void setTimeEnd(Date timeEnd) {
		this.timeEnd = timeEnd;
	}


	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}


	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

}