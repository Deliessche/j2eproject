package com.al2.ddk.jee.service;

// import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.any;
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
//import org.springframework.test.context.junit4.SpringRunner;

import com.al2.ddk.jee.domain.User;
import com.al2.ddk.jee.repository.UserRepository;
import com.al2.ddk.jee.service.impl.UserServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

	@Mock
	private UserRepository userRepository;

	@InjectMocks
	private UserServiceImpl userService;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void shouldReturnAllUsers() {
		// Given
		List<User> users = new ArrayList<User>();
		User user = new User();
		users.add(user);
		// When
		when(userService.getAllUser()).thenReturn(users);
		// Then
		assertTrue("lists should be equals", userService.getAllUser().equals(users));
	}

	@Test
	public void shouldReturnEmptyListUser() {
		// When
		when(userService.getAllUser()).thenReturn(Collections.emptyList());
		// Then
		assertTrue("list should be empty", userService.getAllUser().isEmpty());
	}

	@Test
	public void shouldReturnUserById() {
		// Given
		User user = new User();
		// When
		when(userService.getUser(anyInt())).thenReturn(user);
		// Then
		//assertThat(userService.getUser(anyInt())).isEqualTo(user);
		assertTrue("users should be equals", userService.getUser(anyInt()).equals(user));
	}

	@Test
	public void shouldNotReturnUserById() {
		// When
		when(userService.getUser(anyInt())).thenReturn(null);
		// Then
		assertTrue("user should be null", userService.getUser(anyInt()) == null);
	}

	@Test
	public void shouldReturnUserByEmail() {
		// Given
		User user = new User();
		// When
		when(userService.getUser(any())).thenReturn(user);
		// Then
		assertTrue("users should be equals", userService.getUser(any()).equals(user));
	}

	@Test
	public void shouldNotReturnUserByEmail() {
		// When
		when(userService.getUser(any())).thenReturn(null);
		// Then
		assertTrue("user should be null", userService.getUser(any()) == null);
	}
}
