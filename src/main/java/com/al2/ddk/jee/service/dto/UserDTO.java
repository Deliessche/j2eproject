package com.al2.ddk.jee.service.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.al2.ddk.jee.domain.NetflischOrder;
import com.al2.ddk.jee.domain.User;


public class UserDTO {

	/***/
	private Integer idU;
	/***/
	private String firstNameU;
	/***/
	private String lastNameU;
	/***/
	private String emailU;
	/***/
	private String passwordU;
	/***/
	private List<Integer> idOrders;

	/***/
	public UserDTO() {}

	/***/
	public UserDTO(User user) {
		this.idU = user.getIdU();
		this.firstNameU = user.getFirstNameU();
		this.lastNameU = user.getLastNameU();
		this.emailU = user.getEmailU();
		this.passwordU = user.getPasswordU();
		if(user.getOrders() != null) {
			this.idOrders = user.getOrders().stream().map(NetflischOrder::getIdO).collect(Collectors.toList());
		}
	}

	/**
	 * @return the idU
	 */
	public Integer getIdU() {
		return idU;
	}

	/**
	 * @param idU the idU to set
	 */
	public void setIdU(Integer idU) {
		this.idU = idU;
	}

	/**
	 * @return the firstNameU
	 */
	public String getFirstNameU() {
		return firstNameU;
	}

	/**
	 * @param firstNameU the firstNameU to set
	 */
	public void setFirstNameU(String firstNameU) {
		this.firstNameU = firstNameU;
	}

	/**
	 * @return the lastNameU
	 */
	public String getLastNameU() {
		return lastNameU;
	}

	/**
	 * @param lastNameU the lastNameU to set
	 */
	public void setLastNameU(String lastNameU) {
		this.lastNameU = lastNameU;
	}

	/**
	 * @return the emailU
	 */
	public String getEmailU() {
		return emailU;
	}

	/**
	 * @param emailU the emailU to set
	 */
	public void setEmailU(String emailU) {
		this.emailU = emailU;
	}

	/**
	 * @return the passwordU
	 */
	public String getPasswordU() {
		return passwordU;
	}

	/**
	 * @param passwordU the passwordU to set
	 */
	public void setPasswordU(String passwordU) {
		this.passwordU = passwordU;
	}

	/**
	 * @return the idOrders
	 */
	public List<Integer> getIdOrders() {
		return idOrders;
	}

	/**
	 * @param idOrders the idOrders to set
	 */
	public void setIdOrders(List<Integer> idOrders) {
		this.idOrders = idOrders;
	}
}
