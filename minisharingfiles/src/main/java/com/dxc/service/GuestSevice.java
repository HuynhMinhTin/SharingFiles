package com.dxc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dxc.dao.GUESTDAO;
import com.dxc.daoImp.GuestServiceImp;
import com.dxc.entitty.FileEntity;

@Service
public class GuestSevice implements GuestServiceImp{
	@Autowired
	GUESTDAO GuestDAO;

	public boolean UploadFile(FileEntity file) {
		// TODO Auto-generated method stub
		boolean check = GuestDAO.UploadFile(file);
		return false;
	}

	public boolean DownloadFile(FileEntity file) {
		// TODO Auto-generated method stub
		return false;
	}

	public List<FileEntity> GetAllInfoFile() {
		// TODO Auto-generated method stub
		List<FileEntity> file = GuestDAO.GetAllInfoFile();
		return file;
	}

}
