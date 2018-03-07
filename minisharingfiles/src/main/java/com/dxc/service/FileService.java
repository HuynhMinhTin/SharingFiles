package com.dxc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dxc.dao.FileDAO;
import com.dxc.daoImp.FileDAOImp;
import com.dxc.entitty.FileEntity;
import com.dxc.entitty.UserEntity;


@Service
public class FileService implements FileDAOImp{
	
	@Autowired
	FileDAO fileDAO;

	public boolean UploadFile(FileEntity file) {
		// TODO Auto-generated method stub
		
		boolean check = fileDAO.UploadFile(file);
		return check;
	}

	public boolean DownloadFile(FileEntity file) {
		// TODO Auto-generated method stub
		return false;
	}

	public List<FileEntity> GetInfoFile(int idUser) {
		// TODO Auto-generated method stub
		
		List<FileEntity> file = fileDAO.GetInfoFile(idUser);
		
		return file;
	}

	public int GetIdUser(int idUser) {
		// TODO Auto-generated method stub
		int idLevel = fileDAO.GetIdUser(idUser);
		return idLevel;
	}

	
}
