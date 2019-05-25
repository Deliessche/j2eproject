package com.al2.ddk.jee.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.al2.ddk.jee.domain.NetflischOrder;

@Service
public interface NetflischOrderService {

	/**
	 * retourne la liste des NetflischOrder
	 * @return une liste de NetflischOrder
	 */
	List<NetflischOrder> getAllNetflischOrders();

	/**
	 * retourne un NetflischOrder en fonction de son identifiant
	 * @param id
	 * @return un NetflischOrder
	 */
	NetflischOrder getNetflischOrder(int id);

	/**
	 * permet de savoir si un NetflischOrder possédant cet identifiant existe déjà
	 * @param id
	 * @return true si le NetflischOrder existe, sinon false
	 */
	boolean isNetflischOrderExist(int id);

	/**
	 * retourne la liste des NetflischOrder d'un utilisateur en fonction de son identifiant
	 * @param idUser
	 * @return une liste de NetflischOrder
	 */
	List<NetflischOrder> getAllOrdersOfUser(int idUser);
}