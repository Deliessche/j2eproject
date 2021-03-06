package com.al2.ddk.jee.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Copy {

	/***/
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idC")
	private Integer idC;
	/***/
	@ManyToOne
	private Movie movie;
	/***/
	@ManyToOne
	private NetflischOrder order;

	/***/
	public Copy() {}

	/**
	 * @return the idC
	 */
	public Integer getIdC() {
		return idC;
	}

	/**
	 * @param idC the idCopy to set
	 */
	public void setIdCopy(Integer idC) {
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
	 * @return the command
	 */
	public NetflischOrder getOrder() {
		return order;
	}

	/**
	 * @param order the command to set
	 */
	public void setOrder(NetflischOrder order) {
		this.order = order;
	}
}
