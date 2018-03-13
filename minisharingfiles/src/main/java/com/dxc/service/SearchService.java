package com.dxc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dxc.dao.SearchDAO;
import com.dxc.daoImp.SearchImp;
import com.dxc.entitty.FileEntity;


@Service
public class SearchService implements SearchImp{
	
	@Autowired
	SearchDAO searchDAO;
	

	public List<FileEntity> SearchFile(String keyword) {
		// TODO Auto-generated method stub
		
		List<FileEntity> file = searchDAO.SearchFile(keyword);
		
		return file;
	}

	public void indexBooks() throws Exception {
		// TODO Auto-generated method stub
		searchDAO.indexBooks();
	}

}
