package com.al2.ddk.jee.service.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.al2.ddk.jee.domain.Copy;
import com.al2.ddk.jee.domain.NetflischOrder;
import com.al2.ddk.jee.domain.User;

public class NetflischOrderDTO {

	/***/
	private Integer idO;
	/***/
	private User user;
	/***/
	private List<Integer> idCopies;

	/***/
	public NetflischOrderDTO() {}

	/***/
	public NetflischOrderDTO(NetflischOrder order) {
		this.idO = order.getIdO();
		this.user = order.getUser();
		if(order.getCopies() != null) {
			this.idCopies = order.getCopies().stream().map(Copy::getIdC).collect(Collectors.toList());
		}
	}

	/**
	 * @return the idO
	 */
	public Integer getIdO() {
		return idO;
	}

	/**
	 * @param idO the idO to set
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
	 * @return the idCopies
	 */
	public List<Integer> getIdCopies() {
		return idCopies;
	}

	/**
	 * @param idCopies the idCopies to set
	 */
	public void setIdCopies(List<Integer> idCopies) {
		this.idCopies = idCopies;
	}
}
