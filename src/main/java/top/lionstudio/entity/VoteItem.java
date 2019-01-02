package top.lionstudio.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the zw_vote_item database table.
 * 
 */
@Entity
@Table(name="zw_vote_item")
@NamedQuery(name="ZwVoteItem.findAll", query="SELECT z FROM VoteItem z")
public class VoteItem implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private int idUser;
	private int idVote;
	private String result;
	private Date timeVote;

	public VoteItem() {
	}


	@Id
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}


	@Column(name="id_user")
	public int getIdUser() {
		return this.idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}


	@Column(name="id_vote")
	public int getIdVote() {
		return this.idVote;
	}

	public void setIdVote(int idVote) {
		this.idVote = idVote;
	}


	public String getResult() {
		return this.result;
	}

	public void setResult(String result) {
		this.result = result;
	}


	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="time_vote")
	public Date getTimeVote() {
		return this.timeVote;
	}

	public void setTimeVote(Date timeVote) {
		this.timeVote = timeVote;
	}

}