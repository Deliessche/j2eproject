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
	@Column(name = "idCopy")
	private Integer idCopy;
	/***/
	boolean isAvailable = true;
	/***/
	@ManyToOne
	private Movie movie;
	/***/
	@ManyToOne
	private Order order;
	
	/***/
	public Copy() {}

	/**
	 * @return the idCopy
	 */
	public Integer getIdCopy() {
		return idCopy;
	}

	/**
	 * @param idCopy the idCopy to set
	 */
	public void setIdCopy(Integer idCopy) {
		this.idCopy = idCopy;
	}

	/**
	 * @return the isAvailable
	 */
	public boolean isAvailable() {
		return isAvailable;
	}

	/**
	 * @param isAvailable the isAvailable to set
	 */
	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
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
	public Order getOrder() {
		return order;
	}

	/**
	 * @param order the command to set
	 */
	public void setOrder(Order order) {
		this.order = order;
	}
}
