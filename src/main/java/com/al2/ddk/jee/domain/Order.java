package com.al2.ddk.jee.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Order {

	/***/
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idC")
	private Integer idC;
	/***/
	@ManyToOne
	private User user;
	/***/
	@OneToMany(mappedBy="order")
	private List<Copy> copies;

	/***/
	public Order() {}

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
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return the copies
	 */
	public List<Copy> getCopies() {
		return copies;
	}

	/**
	 * @param copies the copies to set
	 */
	public void setCopies(List<Copy> copies) {
		this.copies = copies;
	}
}
