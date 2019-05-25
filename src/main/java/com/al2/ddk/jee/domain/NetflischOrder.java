package com.al2.ddk.jee.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class NetflischOrder {

	/***/
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idO")
	private Integer idO;
	/***/
	@ManyToOne
	private User user;
	/***/
	@JsonIgnore
	@OneToMany(mappedBy="order")
	private List<Copy> copies;

	/***/
	public NetflischOrder() {}

	/**
	 * @return the idO
	 */
	public Integer getIdO() {
		return idO;
	}

	/**
	 * @param idC the idO to set
	 */
	public void setIdO(Integer idO) {
		this.idO = idO;
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
