package top.lionstudio.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the zw_room_info database table.
 * 
 */
@Entity
@Table(name="zw_room_info")
@NamedQuery(name="ZwRoomInfo.findAll", query="SELECT z FROM RoomInfo z")
public class RoomInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String address;
	private String des;
	private Integer idPart;
	private String name;

	public RoomInfo() {
	}


	@Id
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


	public String getDes() {
		return this.des;
	}

	public void setDes(String des) {
		this.des = des;
	}


	@Column(name="id_part")
	public Integer getIdPart() {
		return this.idPart;
	}

	public void setIdPart(int idPart) {
		this.idPart = idPart;
	}


	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}