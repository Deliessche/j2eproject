package com.al2.ddk.jee.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.al2.ddk.jee.domain.Copy;
import com.al2.ddk.jee.domain.Movie;
import com.al2.ddk.jee.domain.NetflischOrder;
import com.al2.ddk.jee.repository.CopyRepository;
import com.al2.ddk.jee.service.CopyService;
import com.al2.ddk.jee.service.MovieService;
import com.al2.ddk.jee.service.NetflischOrderService;

@Service("CopyService")
public class CopyServiceImpl implements CopyService{

	/***/
	private final CopyRepository copyRepository;
	/***/
	private NetflischOrderService netflischOrderService;
	/***/
	private MovieService movieService;
	/***/
	@Autowired
	public CopyServiceImpl(CopyRepository copyRepository, NetflischOrderService netflischOrderService, MovieService movieService) {
		this.copyRepository = copyRepository;
		this.netflischOrderService = netflischOrderService;
		this.movieService = movieService;
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

	/******/
	@Override
	public void createCopy(NetflischOrder order, Movie movie) throws Exception {
		if(movieService.getMovie(movie.getIdM()) == null) {
			throw new Exception("Erreur, le film n'existe pas");
		}
		if(netflischOrderService.getNetflischOrder(order.getIdO()) == null) {
			throw new Exception("Erreur, la commande n'existe pas");
		}
		Copy copy = new Copy();
		copy.setMovie(movie);
		copy.setOrder(order);
		copyRepository.save(copy);
	}
}
