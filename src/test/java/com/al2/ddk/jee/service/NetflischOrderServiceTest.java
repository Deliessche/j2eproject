package com.al2.ddk.jee.service;

import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.al2.ddk.jee.domain.NetflischOrder;
import com.al2.ddk.jee.repository.NetflischOrderRepository;
import com.al2.ddk.jee.service.impl.NetflischOrderServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class NetflischOrderServiceTest {

	@Mock
	private NetflischOrderRepository netflischOrderRepository;

	@InjectMocks
	private NetflischOrderServiceImpl netflischOrderService;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void shouldReturnAllOrder() {
		// Given
		List<NetflischOrder> orders = new ArrayList<>();
		NetflischOrder order = new NetflischOrder();
		orders.add(order);
		// When
		when(netflischOrderService.getAllNetflischOrders()).thenReturn(orders);
		// Then
		assertTrue("lists should be equals", netflischOrderService.getAllNetflischOrders().equals(orders));
	}

	@Test
	public void shouldReturnEmptyListOrder() {
		// When
		when(netflischOrderService.getAllNetflischOrders()).thenReturn(Collections.emptyList());
		// Then
		assertTrue("list should be empty", netflischOrderService.getAllNetflischOrders().isEmpty());
	}

	@Test
	public void shouldReturnAllOrderOfUser() {
		// Given
		List<NetflischOrder> orders = new ArrayList<>();
		NetflischOrder order = new NetflischOrder();
		orders.add(order);
		// When
		when(netflischOrderService.getAllOrdersOfUser(anyInt())).thenReturn(orders);
		// Then
		assertTrue("lists should be equals", netflischOrderService.getAllOrdersOfUser(anyInt()).equals(orders));
	}

	@Test
	public void shouldReturnEmptyListOrderOfUser() {
		// When
		when(netflischOrderService.getAllOrdersOfUser(anyInt())).thenReturn(Collections.emptyList());
		// Then
		assertTrue("list should be emtpy", netflischOrderService.getAllOrdersOfUser(anyInt()).isEmpty());
	}

	@Test
	public void shouldReturnOrderById() {
		// Given
		NetflischOrder order = new NetflischOrder();
		// When
		when(netflischOrderService.getNetflischOrder(anyInt())).thenReturn(order);
		// Then
		assertTrue("orders should be equals", netflischOrderService.getNetflischOrder(anyInt()).equals(order));
	}
}
