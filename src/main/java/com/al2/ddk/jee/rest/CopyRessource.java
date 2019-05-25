package com.al2.ddk.jee.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.al2.ddk.jee.domain.Copy;
import com.al2.ddk.jee.exception.NetflischException;
import com.al2.ddk.jee.repository.CopyRepository;
import com.al2.ddk.jee.service.CopyService;

@RestController
@RequestMapping("/api")
public class CopyRessource {

	/***/
	private final Logger log = LoggerFactory.getLogger(CopyRessource.class);
	/***/
	@Autowired
	private CopyRepository copyRepository;
	/***/
	private CopyService copyService;

	/***/
	public CopyRessource(CopyRepository copyRepository, CopyService copyService) {
		this.copyRepository = copyRepository;
		this.copyService = copyService;
	}

	/**
	 * retourne tous les exemplaires des films de Netflisch
	 * @return les copies
	 */
	@GetMapping("/copies")
	public List<Copy> getAllCopies(){
		List<Copy> copies = copyService.getAllCopies();
		return copies;
	}

	/**
	 * retourne un exemplaire d'un film Netflisch
	 * @param id
	 * @return une Copy
	 * @throws NetflischException
	 */
	@GetMapping("/copies/{id}")
	public Copy getCopyById(@PathVariable int id) throws NetflischException {
		Copy copy = copyService.getCopy(id);
		if(copy == null) {
			throw new NetflischException(HttpStatus.NOT_FOUND.value(), "Cet exemplaire n'existe pas");
		} else {
			return copy;
		}
	}
}
