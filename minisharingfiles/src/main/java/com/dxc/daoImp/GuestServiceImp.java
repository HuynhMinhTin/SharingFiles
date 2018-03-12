package com.dxc.daoImp;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dxc.entitty.FileEntity;

@Service
public interface GuestServiceImp {
	public boolean UploadFile(FileEntity file);
	public boolean DownloadFile(FileEntity file);
	public List<FileEntity> GetAllInfoFile();
}
