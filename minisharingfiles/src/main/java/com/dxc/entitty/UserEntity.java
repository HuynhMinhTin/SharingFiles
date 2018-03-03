package com.dxc.entitty;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity(name="user")
public class UserEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int idUser;
	
	String nameUser;
	String emailUser;
	String passwordUser;
	
	@OneToOne
	@JoinColumn(name="idPosition")
	PositionEntity idPosition;
	
	@OneToMany
	@JoinColumn(name="idFile")
	Set<FileEntity> idFile;
	
	
	
	
	
	
	
	public Set<FileEntity> getIdFile() {
		return idFile;
	}
	public void setIdFile(Set<FileEntity> idFile) {
		this.idFile = idFile;
	}
	public PositionEntity getIdPosition() {
		return idPosition;
	}
	public void setIdPosition(PositionEntity idPosition) {
		this.idPosition = idPosition;
	}
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public String getNameUser() {
		return nameUser;
	}
	public void setNameUser(String nameUser) {
		this.nameUser = nameUser;
	}
	public String getEmailUser() {
		return emailUser;
	}
	public void setEmailUser(String emailUser) {
		this.emailUser = emailUser;
	}
	public String getPasswordUser() {
		return passwordUser;
	}
	public void setPasswordUser(String passwordUser) {
		this.passwordUser = passwordUser;
	}
	public UserEntity(int idUser, String nameUser, String emailUser,
			String passwordUser, Set<FileEntity> idFile,
			PositionEntity idPosition) {
		super();
		this.idUser = idUser;
		this.nameUser = nameUser;
		this.emailUser = emailUser;
		this.passwordUser = passwordUser;
		this.idFile = idFile;
		this.idPosition = idPosition;
	}
	public UserEntity() {
		super();
	}
	@Override
	public String toString() {
		return "UserEntity [idUser=" + idUser + ", nameUser=" + nameUser + ", emailUser=" + emailUser
				+ ", passwordUser=" + passwordUser + ", idFile=" + idFile + ", idPosition=" + idPosition + "]";
	}
	
	
	
	
}
