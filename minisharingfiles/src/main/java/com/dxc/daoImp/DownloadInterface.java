package com.dxc.daoImp;

import com.dxc.entitty.FileEntity;
import com.dxc.entitty.UserEntity;

public interface DownloadInterface {
	byte[] getDataById(int _id);
	String getFileNameById(int _id);
	FileEntity getFileById(int _id);
	UserEntity getUserByUserId(int _id);	
}
