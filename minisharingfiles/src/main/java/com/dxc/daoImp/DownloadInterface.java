package com.dxc.daoImp;

import com.dxc.entitty.FileEntity;

public interface DownloadInterface {
	byte[] getDataById(int _id);
	String getFileNameById(int _id);
	FileEntity getFileById(int _id);
}
