package com.al2.ddk.jee.service.dto;

import com.al2.ddk.jee.domain.Copy;
import com.al2.ddk.jee.domain.Movie;
import com.al2.ddk.jee.domain.NetflischOrder;

public class CopyDTO {

	/***/
	private Integer idC;
	/***/
	private Movie movie;
	/***/
	private NetflischOrder order;

	/***/
	public CopyDTO() {}

	/***/
	public CopyDTO(Copy copy) {
		this.idC = copy.getIdC();
		this.movie = copy.getMovie();
		if(copy.getOrder() != null) {
			this.order = copy.getOrder();
		}
	}

	/**
	 * @return the idC
	 */
	public Integer getIdC() {
		return idC;
	}

	/**
	 * @param idC the idC to set
	 */
	public void setIdC(Integer idC) {
		this.idC = idC;
	}

	/**
	 * @return the movie
	 */
	public Movie getMovie() {
		return movie;
	}

	/**
	 * @param movie the movie to set
	 */
	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	/**
	 * @return the order
	 */
	public NetflischOrder getOrder() {
		return order;
	}

	/**
	 * @param order the order to set
	 */
	public void setOrder(NetflischOrder order) {
		this.order = order;
	}
}
