package com.dxc.entitty;

import java.sql.Date;
import java.time.LocalDateTime;
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


@Entity(name="user")
public class UserEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int idUser;
	
	String nameUser;
	String emailUser;
	String passwordUser;
	long totalSize;
	long storageDaily;
	Date lastDownload;
	
	@OneToOne
	@JoinColumn(name="idPosition")
	PositionEntity idPosition;
	
	@OneToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="idFile")
	Set<FileEntity> idFile;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="idLevel")	
	LevelUserEntity idLevel;
	
	
	public long getStorageDaily() {
		return storageDaily;
	}

	public void setStorageDaily(long storageDail) {
		this.storageDaily = storageDail;
	}

	public Date getLastDownload() {
		return lastDownload;
	}

	public void setLastDownload(Date lastDownload) {
		this.lastDownload = lastDownload;
	}

	public long getTotalSize() {
		return totalSize;
	}

	public void setTotalSize(long totalSize) {
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
		this.lastDownload = Date.valueOf(LocalDateTime.now().toLocalDate());
	}

	public UserEntity(int idUser, String nameUser, String emailUser,
			String passwordUser, long totalSize, long storageDaily,
			Date lastDownload, PositionEntity idPosition,
			Set<FileEntity> idFile, LevelUserEntity idLevel) {
		super();
		this.idUser = idUser;
		this.nameUser = nameUser;
		this.emailUser = emailUser;
		this.passwordUser = passwordUser;
		this.totalSize = totalSize;
		this.storageDaily = storageDaily;
		this.lastDownload = lastDownload;
		this.idPosition = idPosition;
		this.idFile = idFile;
		this.idLevel = idLevel;
	}

	@Override
	public String toString() {
		return "UserEntity [idUser=" + idUser + ", nameUser=" + nameUser + ", emailUser=" + emailUser
				+ ", passwordUser=" + passwordUser + ", idFile=" + idFile + ", idPosition=" + idPosition + "]";
	}
	
	
	
	
}