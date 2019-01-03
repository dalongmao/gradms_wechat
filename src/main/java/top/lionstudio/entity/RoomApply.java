package top.lionstudio.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the zw_room_apply database table.
 * 
 */
@Entity
@Table(name="zw_room_apply")
@NamedQuery(name="ZwRoomApply.findAll", query="SELECT z FROM RoomApply z")
public class RoomApply implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String brief;
	private Date dateActivity;
	private Integer idApplyer;
	private Integer idRoom;
	private Date timeApply;
	private String timenodes;

	public RoomApply() {
	}


	@Id
	public Integer getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getBrief() {
		return this.brief;
	}

	public void setBrief(String brief) {
		this.brief = brief;
	}


	@Temporal(TemporalType.DATE)
	@Column(name="date_activity")
	public Date getDateActivity() {
		return this.dateActivity;
	}

	public void setDateActivity(Date dateActivity) {
		this.dateActivity = dateActivity;
	}


	@Column(name="id_applyer")
	public Integer getIdApplyer() {
		return this.idApplyer;
	}

	public void setIdApplyer(int idApplyer) {
		this.idApplyer = idApplyer;
	}


	@Column(name="id_room")
	public Integer getIdRoom() {
		return this.idRoom;
	}

	public void setIdRoom(int idRoom) {
		this.idRoom = idRoom;
	}


	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="time_apply")
	public Date getTimeApply() {
		return this.timeApply;
	}

	public void setTimeApply(Date timeApply) {
		this.timeApply = timeApply;
	}


	public String getTimenodes() {
		return this.timenodes;
	}

	public void setTimenodes(String timenodes) {
		this.timenodes = timenodes;
	}

}