	package com.dxc.entitty;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.Store;

@Indexed
@Entity(name="user")
public class UserEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int idUser;
	
	 @Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	String nameUser;
	String emailUser;
	String passwordUser;
	
	@OneToOne
	@JoinColumn(name="idPosition")
	PositionEntity idPosition;
	
	@OneToMany(cascade=CascadeType.ALL ,  orphanRemoval=true )
	@JoinColumn(name="idFile")
	Set<FileEntity> idFile;
	
	@OneToOne
	@JoinColumn(name="idLevel")
	LevelUserEntity idLevel;
	
	
	long totalSize;
	
	
	
	
	
	public long getTotalSize() {
		return totalSize;
	}

	public void setTotalSize(long totalSize) {
		this.totalSize = totalSize;
	}

	
	
	public UserEntity(int idUser, String nameUser, String emailUser,
			String passwordUser, PositionEntity idPosition,
			Set<FileEntity> idFile, LevelUserEntity idLevel, long totalSize) {
		super();
		this.idUser = idUser;
		this.nameUser = nameUser;
		this.emailUser = emailUser;
		this.passwordUser = passwordUser;
		this.idPosition = idPosition;
		this.idFile = idFile;
		this.idLevel = idLevel;
		this.totalSize = totalSize;
	}
	
	

	public LevelUserEntity getIdLevel() {
		return idLevel;
	}
	public void setIdLevel(LevelUserEntity idLevel) {
		this.idLevel = idLevel;
	}
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
	public UserEntity() {
		super();
	}
	@Override
	public String toString() {
		return "UserEntity [idUser=" + idUser + ", nameUser=" + nameUser + ", emailUser=" + emailUser
				+ ", passwordUser=" + passwordUser + ", idFile=" + idFile + ", idPosition=" + idPosition + "]";
	}

}
