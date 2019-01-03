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
	private Integer idUser;
	private Integer idVote;
	private String result;
	
	private Date timeVoteLast;
	
	private Integer num_submit;

	public VoteItem() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}


	@Column(name="id_user")
	public Integer getIdUser() {
		return this.idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}


	@Column(name="id_vote")
	public Integer getIdVote() {
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
	@Column(name="time_vote_last")
	public Date getTimeVoteLast() {
		return timeVoteLast;
	}


	public void setTimeVoteLast(Date timeVoteLast) {
		this.timeVoteLast = timeVoteLast;
	}


	public Integer getNum_submit() {
		return num_submit;
	}


	public void setNum_submit(Integer num_submit) {
		this.num_submit = num_submit;
	}

}