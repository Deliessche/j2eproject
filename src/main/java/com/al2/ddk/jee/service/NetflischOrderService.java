package com.al2.ddk.jee.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.al2.ddk.jee.domain.NetflischOrder;
import com.al2.ddk.jee.domain.User;

@Service
public interface NetflischOrderService {

	/**
	 * retourne la liste des NetflischOrder
	 * @return une liste de NetflischOrder
	 */
	List<NetflischOrder> getAllNetflischOrders();

	/**
	 * retourne la liste des NetflischOrder d'un utilisateur en fonction de son identifiant
	 * @param idUser
	 * @return une liste de NetflischOrder
	 */
	List<NetflischOrder> getAllOrdersOfUser(int idUser);

	/**
	 * retourne un NetflischOrder en fonction de son identifiant
	 * @param id
	 * @return un NetflischOrder
	 */
	NetflischOrder getNetflischOrder(int id);

	/**
	 * créer un NetflischOrder
	 * @param user
	 * @return un NetflischOrder
	 */
	NetflischOrder createNetflischOrder(User user);

	/**
	 * supprime un NetflischOrder en fonction de son identifiant
	 * @param id
	 */
	void deleteNetflischOrder(int id);

	/**
	 * permet de savoir si un NetflischOrder possédant cet identifiant existe déjà
	 * @param id
	 * @return true si le NetflischOrder existe, sinon false
	 */
	boolean isNetflischOrderExist(int id);
}