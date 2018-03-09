package com.dxc.daoImp;

import java.util.List;

import com.dxc.entitty.FileEntity;


public interface FileDAOImp {

	boolean UploadFile(FileEntity file);
	boolean DownloadFile(FileEntity file);
	List<FileEntity> GetInfoFile(int idUser);
	int GetIdUser(int idUser);	
}
