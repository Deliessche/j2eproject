package com.al2.ddk.jee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.al2.ddk.jee.domain.NetflischOrder;

@Repository
public interface NetflischOrderRepository extends JpaRepository<NetflischOrder, Integer>{

	/**
	 * renvoie la liste des NetflischOrder
	 * @return une liste de NetflischOrder
	 */
	List<NetflischOrder> findAll();

	/**
	 * renvoie un NetflischOrder en fonction de son id
	 * @param id
	 * @return un objet NetflischOrder
	 */
	@Query("SELECT n FROM NetflischOrder n WHERE n.id = :id")
	NetflischOrder findById(@Param("id") int id);

	/**
	 * renvoie la liste des NetflischOrder d'un User en fonction de son id
	 * @param id
	 * @return une liste de NetflischOrder
	 */
	@Query("SELECT n FROM NetflischOrder n WHERE n.user.id = :id")
	List<NetflischOrder> findAllByUserId(@Param("id") int id);
}