package com.dxc.daoImp;

import java.util.List;

import com.dxc.entitty.FileEntity;

public interface GUESTDAOImp {
	boolean UploadFile(FileEntity file);
	boolean DownloadFile(FileEntity file);
	List<FileEntity> GetAllInfoFile();
}
