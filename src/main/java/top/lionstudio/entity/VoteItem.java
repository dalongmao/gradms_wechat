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

	@Id
	private int id;

	@Column(name="id_user")
	private int idUser;

	@Column(name="id_vote")
	private int idVote;

	private String result;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="time_vote")
	private Date timeVote;

	public VoteItem() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdUser() {
		return this.idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

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

	public Date getTimeVote() {
		return this.timeVote;
	}

	public void setTimeVote(Date timeVote) {
		this.timeVote = timeVote;
	}

}