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



@Entity(name="file")
public class FileEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int idFile ;
	
	@OneToMany(fetch=FetchType.EAGER ,cascade=CascadeType.ALL)
	@JoinColumn(name="idCategory")
	Set<CategoryEntity> idCategory;
	
	@OneToOne
	@JoinColumn(name="idUser")
	UserEntity idUser;
	
	String nameFile;
	int sizeFile;
	String commentFile;
	String detail;
	String dateCreateFile;//date
	String statusFile;
	String imageLinksFile;
	int countDowloadFile;
	
	
	public Set<CategoryEntity> getIdCategory() {
		return idCategory;
	}
	public void setIdCategory(Set<CategoryEntity> idCategory) {
		this.idCategory = idCategory;
	}
	public UserEntity getIdUser() {
		return idUser;
	}
	public void setIdUser(UserEntity idUser) {
		this.idUser = idUser;
	}
	public String getNameFile() {
		return nameFile;
	}
	public void setNameFile(String nameFile) {
		this.nameFile = nameFile;
	}
	public int getSizeFile() {
		return sizeFile;
	}
	public void setSizeFile(int sizeFile) {
		this.sizeFile = sizeFile;
	}
	public int getIdFile() {
		return idFile;
	}
	public void setIdFile(int idFile) {
		this.idFile = idFile;
	}
	public String getCommentFile() {
		return commentFile;
	}
	public void setCommentFile(String commentFile) {
		this.commentFile = commentFile;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public String getDateCreateFile() {
		return dateCreateFile;
	}
	public void setDateCreateFile(String dateCreateFile) {
		this.dateCreateFile = dateCreateFile;
	}
	public String getStatusFile() {
		return statusFile;
	}
	public void setStatusFile(String statusFile) {
		this.statusFile = statusFile;
	}
	public String getImageLinksFile() {
		return imageLinksFile;
	}
	public void setImageLinksFile(String imageLinksFile) {
		this.imageLinksFile = imageLinksFile;
	}
	public int getCountDowloadFile() {
		return countDowloadFile;
	}
	public void setCountDowloadFile(int countDowloadFile) {
		this.countDowloadFile = countDowloadFile;
	}
	
	public FileEntity(int idFile, Set<CategoryEntity> idCategory,
			UserEntity idUser, String nameFile, int sizeFile,
			String commentFile, String detail, String dateCreateFile,
			String statusFile, String imageLinksFile, int countDowloadFile) {
		super();
		this.idFile = idFile;
		this.idCategory = idCategory;
		this.idUser = idUser;
		this.nameFile = nameFile;
		this.sizeFile = sizeFile;
		this.commentFile = commentFile;
		this.detail = detail;
		this.dateCreateFile = dateCreateFile;
		this.statusFile = statusFile;
		this.imageLinksFile = imageLinksFile;
		this.countDowloadFile = countDowloadFile;
	}
	public FileEntity() {
		super();
	}
	
	
	
	
}
