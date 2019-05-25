package com.al2.ddk.jee.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.al2.ddk.jee.domain.NetflischOrder;
import com.al2.ddk.jee.exception.NetflischException;
import com.al2.ddk.jee.repository.NetflischOrderRepository;
import com.al2.ddk.jee.service.NetflischOrderService;

@RestController
@RequestMapping("/api")
public class NetflischOrderRessource {

	/***/
	private final Logger log = LoggerFactory.getLogger(NetflischOrderRessource.class);
	/***/
	@Autowired
	private NetflischOrderRepository netflischOrderRepository;
	/***/
	private NetflischOrderService netflischOrderService;

	/***/
	public NetflischOrderRessource(NetflischOrderRepository netflischOrderRepository, NetflischOrderService netflischOrderService) {
		this.netflischOrderRepository = netflischOrderRepository;
		this.netflischOrderService = netflischOrderService;
	}

	/**
	 * retourne toute la liste des commandes de Netflisch
	 * @return une liste de NetflischOrder
	 */
	@GetMapping("/orders")
	public List<NetflischOrder> getAllNetflischOrders() {
		List<NetflischOrder> allOrders = netflischOrderService.getAllNetflischOrders();
		return allOrders;
	}

	/**
	 * retourne une commande de Netflisch
	 * @param id
	 * @return un NetflischOrder
	 * @throws NetflischException
	 */
	@GetMapping("/orders/{id}")
	public NetflischOrder getNetflischOrderById(@PathVariable int id) throws NetflischException {
		NetflischOrder order = netflischOrderService.getNetflischOrder(id);
		if(order == null) {
			throw new NetflischException(HttpStatus.NOT_FOUND.value(), "Cette commande n'existe pas");
		} else {
			return order;
		}
	}
}
