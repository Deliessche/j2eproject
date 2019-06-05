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

import com.al2.ddk.jee.domain.Copy;
import com.al2.ddk.jee.repository.CopyRepository;
import com.al2.ddk.jee.service.impl.CopyServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class CopyServiceTest {

	@Mock
	private CopyRepository copyRepository;

	@InjectMocks
	private CopyServiceImpl copyService;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void shouldReturnAllCopies() {
		// Given
		List<Copy> copies = new ArrayList<>();
		Copy copy = new Copy();
		copies.add(copy);
		// When
		when(copyService.getAllCopies()).thenReturn(copies);
		// Then
		assertTrue("lists should be equals", copyService.getAllCopies().equals(copies));
	}

	@Test
	public void shouldReturnEmptyListCopies() {
		// Given
		when(copyService.getAllCopies()).thenReturn(Collections.emptyList());
		// Then
		assertTrue("list should be empty", copyService.getAllCopies().isEmpty());
	}

	@Test
	public void shouldReturnCopyById() {
		// Given
		Copy copy = new Copy();
		// When
		when(copyService.getCopy(anyInt())).thenReturn(copy);
		// Then
		assertTrue("copies should be equals", copyService.getCopy(anyInt()).equals(copy));
	}
}
