package com.al2.ddk.jee.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.al2.ddk.jee.domain.NetflischOrder;
import com.al2.ddk.jee.repository.NetflischOrderRepository;
import com.al2.ddk.jee.service.NetflischOrderService;

@Service("NetflischOrderService")
public class NetflischOrderServiceImpl implements NetflischOrderService{

	/***/
	private final NetflischOrderRepository netflischOrderRepository;
	/***/
	@Autowired
	public NetflischOrderServiceImpl(NetflischOrderRepository netflischOrderRepository) {
		this.netflischOrderRepository = netflischOrderRepository;
	}

	/******/
	@Override
	public List<NetflischOrder> getAllNetflischOrders() {
		return netflischOrderRepository.findAll();
	}

	/******/
	@Override
	public NetflischOrder getNetflischOrder(int id) {
		return netflischOrderRepository.findById(id);
	}

	/******/
	@Override
	public boolean isNetflischOrderExist(int id) {
		if(getNetflischOrder(id) != null) {
			return true;
		} else return false;
	}

	/******/
	@Override
	public List<NetflischOrder> getAllOrdersOfUser(int idUser) {
		return netflischOrderRepository.findAllByUserId(idUser);
	}
}
