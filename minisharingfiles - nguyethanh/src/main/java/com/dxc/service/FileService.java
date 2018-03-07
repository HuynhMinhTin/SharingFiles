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
		return false;
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

	
}
