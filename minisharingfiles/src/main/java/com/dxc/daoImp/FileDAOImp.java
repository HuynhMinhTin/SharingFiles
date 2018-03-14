package com.dxc.daoImp;

import java.util.List;

import com.dxc.entitty.FileEntity;


public interface FileDAOImp {

	boolean UploadFile(FileEntity file);
	boolean DownloadFile(FileEntity file);
	List<FileEntity> GetInfoFile(int idUser);
	int GetIdUser(int idUser);
	
	List<FileEntity> GetFileFromCategoryForUser(int idCategory , int idUser);

	List<FileEntity> GetFileFromCategory(int idCategory);
	
	void UpdateFile(FileEntity file);
	
	FileEntity GetInfoFileDetail(int idFile);
	
	boolean DeleteFile(int  idFile);
}
