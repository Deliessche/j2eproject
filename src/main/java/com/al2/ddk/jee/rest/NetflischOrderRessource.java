package com.al2.ddk.jee.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.al2.ddk.jee.domain.Movie;
import com.al2.ddk.jee.domain.NetflischOrder;
import com.al2.ddk.jee.domain.User;
import com.al2.ddk.jee.exception.NetflischException;
import com.al2.ddk.jee.repository.NetflischOrderRepository;
import com.al2.ddk.jee.service.MovieService;
import com.al2.ddk.jee.service.NetflischOrderService;
import com.al2.ddk.jee.service.UserService;
import com.al2.ddk.jee.service.dto.NetflischOrderDTO;

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
	private MovieService movieService;
	/***/
	private UserService userService;

	/***/
	public NetflischOrderRessource(NetflischOrderRepository netflischOrderRepository, NetflischOrderService netflischOrderService, MovieService movieService, UserService userService) {
		this.netflischOrderRepository = netflischOrderRepository;
		this.netflischOrderService = netflischOrderService;
		this.movieService = movieService;
		this.userService = userService;
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
	 * retourne toute les commandes d'un utilisateur
	 * @param id
	 * @return une liste de NetflischOrder
	 * @throws NetflischException
	 */
	@GetMapping("/orders/users/{id}")
	public List<NetflischOrder> getAllOrdersOfUser(@PathVariable int id) throws NetflischException {
		if(userService.getUser(id) == null) {
			throw new NetflischException(HttpStatus.NOT_FOUND.value(), "Cet utilisateur n'existe pas");
		} else {
			return netflischOrderService.getAllOrdersOfUser(id);
		}
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

	/**
	 * supprime une commande de Netflisch
	 * @param id
	 * @return
	 * @throws NetflischException
	 */
	@DeleteMapping("/orders/{id}")
	public ResponseEntity<Object> deleteNetflischOrder(@PathVariable int id) throws NetflischException {
		if(netflischOrderService.getNetflischOrder(id) == null) {
			throw new NetflischException(HttpStatus.NOT_FOUND.value(), "Cette commande n'existe pas");
		} else {
			netflischOrderService.deleteNetflischOrder(id);
		}
		return ResponseEntity.ok().build();
	}

	/**
	 * creer une commande d'un utilisateur Netflisch
	 * @param user
	 * @return
	 */
	@PostMapping("/orders/movie/{id}")
	public ResponseEntity<Object> createNetflischOrder(@RequestBody User user, @PathVariable int id) throws NetflischException {
		if(userService.getUser(user.getIdU()) == null) {
			throw new NetflischException(HttpStatus.NOT_FOUND.value(), "Cet utilisateur n'existe pas");
		}
		if(movieService.getMovie(id) == null) {
			throw new NetflischException(HttpStatus.NOT_FOUND.value(), "Ce film n'existe pas");
		}
		NetflischOrder order = netflischOrderService.createNetflischOrder(user);
		Movie movie = movieService.getMovie(id);
		try {
			//copyService.createCopy(order, movie);
		} catch (Exception e) {
			throw new NetflischException(HttpStatus.BAD_REQUEST.value(), e.getMessage());
		}
		return ResponseEntity.ok().build();
	}
}
