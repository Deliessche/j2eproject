package com.al2.ddk.jee.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.al2.ddk.jee.domain.Copy;
import com.al2.ddk.jee.domain.Movie;
import com.al2.ddk.jee.domain.NetflischOrder;

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
	
	/**
	 * créer une Copy
	 * @param order
	 * @param movie
	 */
	void createCopy(NetflischOrder order, Movie movie) throws Exception;
}
