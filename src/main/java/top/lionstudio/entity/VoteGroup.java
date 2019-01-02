package top.lionstudio.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the zw_vote_group database table.
 * 
 */
@Entity
@Table(name="zw_vote_group")
@NamedQuery(name="ZwVoteGroup.findAll", query="SELECT z FROM VoteGroup z")
public class VoteGroup implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String des;
	private String name;
	private Date timeCreat;
	private Date timeEnd;

	public VoteGroup() {
	}


	@Id
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getDes() {
		return this.des;
	}

	public void setDes(String des) {
		this.des = des;
	}


	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
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

}