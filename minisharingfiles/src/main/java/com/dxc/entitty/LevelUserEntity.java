package com.dxc.entitty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity(name="level")
public class LevelUserEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int idLevel;
	
	String nameLevel;
	int totalSize;
	
	
	public int getIdLevel() {
		return idLevel;
	}
	public void setIdLevel(int idLevel) {
		this.idLevel = idLevel;
	}
	public String getNameLevel() {
		return nameLevel;
	}
	public void setNameLevel(String nameLevel) {
		this.nameLevel = nameLevel;
	}
	public int getTotalSize() {
		return totalSize;
	}
	public void setTotalSize(int totalSize) {
		this.totalSize = totalSize;
	}
	public LevelUserEntity(int idLevel, String nameLevel, int totalSize) {
		super();
		this.idLevel = idLevel;
		this.nameLevel = nameLevel;
		this.totalSize = totalSize;
	}
	public LevelUserEntity() {
		super();
	}

}
