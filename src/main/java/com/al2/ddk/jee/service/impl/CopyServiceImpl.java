package com.al2.ddk.jee.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.al2.ddk.jee.domain.Copy;
import com.al2.ddk.jee.repository.CopyRepository;
import com.al2.ddk.jee.service.CopyService;

@Service("CopyService")
public class CopyServiceImpl implements CopyService{

	/***/
	private final CopyRepository copyRepository;
	/***/
	@Autowired
	public CopyServiceImpl(CopyRepository copyRepository) {
		this.copyRepository = copyRepository;
	}

	/******/
	@Override
	public List<Copy> getAllCopies() {
		return copyRepository.findAll();
	}

	/******/
	@Override
	public Copy getCopy(int id) {
		return copyRepository.findById(id);
	}
}
