package com.al2.ddk.jee.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.al2.ddk.jee.domain.Copy;

@Service
public interface CopyService {

	/**
	 * retourne la liste des Copies
	 * @return la liste des copies
	 */
	List<Copy> getAllCopies();

	/**
	 * retourne une Copy en fonction de son identifiant
	 * @return une Copy
	 */
	Copy getCopy(int id);
}
