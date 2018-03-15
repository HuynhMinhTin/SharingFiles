package com.dxc.entitty;


import java.sql.Date;
import java.util.Arrays;





import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.FieldBridge;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.Store;
import org.hibernate.search.bridge.builtin.LongBridge;



@Entity(name="file")
@Indexed
public class FileEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int idFile ;
	
	@OneToOne(fetch=FetchType.EAGER )
	@JoinColumn(name="idCategory")
	CategoryEntity idCategory;
	
	
	@OneToOne
	@JoinColumn(name="idUser")
	UserEntity idUser;
	
	
	@Column(name = "nameFile", nullable= false, length = 256)
	 @Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	String nameFile;
	
	@Column(name = "sizeFile", nullable= false, length = 256)
	 @Field(index=Index.YES ,  analyze = Analyze.NO, store=Store.NO)
	 @FieldBridge(impl = LongBridge.class)
	long sizeFile;
	String commentFile;
	byte[] detail;
	Date dateCreateFile;//date
	String statusFile;
	String imageLinksFile;
	int countDowloadFile;
	
	
	
	
	
	
	
	
	public Date getDateCreateFile() {
		return dateCreateFile;
	}
	public void setDateCreateFile(Date dateCreateFile) {
		this.dateCreateFile = dateCreateFile;
	}
	public CategoryEntity getIdCategory() {
		return idCategory;
	}
	public void setIdCategory(CategoryEntity idCategory) {
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
	public long getSizeFile() {
		return sizeFile;
	}
	public void setSizeFile(long l) {
		this.sizeFile = l;
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
	
	
	
	public byte[] getDetail() {
		return detail;
	}
	public void setDetail(byte[] detail) {
		this.detail = detail;
	}
	
	
	public FileEntity() {
		super();
	}
	
	
	
	public FileEntity(int idFile, CategoryEntity idCategory, UserEntity idUser,
			String nameFile, long sizeFile, String commentFile, byte[] detail,
			Date dateCreateFile, String statusFile, String imageLinksFile,
			int countDowloadFile) {
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
	@Override
	public String toString() {
		return "Chan qa ban oi  [idFile=" + idFile + ", idCategory=" + idCategory
				+ ", idUser=" + idUser + ", nameFile=" + nameFile
				+ ", sizeFile=" + sizeFile + ", commentFile=" + commentFile
				+ ", detail=" + Arrays.toString(detail) + ", dateCreateFile="
				+ dateCreateFile + ", statusFile=" + statusFile
				+ ", imageLinksFile=" + imageLinksFile + ", countDowloadFile="
				+ countDowloadFile + "]";
	}

}
