package com.dxc.entitty;




import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity(name="position")
public class PositionEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int idPosition;
	String namePosition;
	

	public int getIdPosition() {
		return idPosition;
	}

	public void setIdPosition(int idPosition) {
		this.idPosition = idPosition;
	}


	public String getNamePosition() {
		return namePosition;
	}

	public void setNamePosition(String namePosition) {
		this.namePosition = namePosition;
	}

	public PositionEntity(int idPosition,
			String namePosition) {
		super();
		this.idPosition = idPosition;
		this.namePosition = namePosition;
	}

	public PositionEntity() {
		super();
	}
	
	

	
	
}
