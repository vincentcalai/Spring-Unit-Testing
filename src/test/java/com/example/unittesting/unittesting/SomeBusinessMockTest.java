package com.example.unittesting.unittesting;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.unittesting.unittesting.business.SomeBusinessImpl;
import com.example.unittesting.unittesting.data.SomeDataService;

@ExtendWith(MockitoExtension.class)
class SomeBusinessMockTest {

	@InjectMocks
	SomeBusinessImpl business;

	@Mock
	SomeDataService dataServiceMock;

	@BeforeEach
	public void before() {
		business.setSomeDataService(dataServiceMock);
	}

	@Test
	void calculateSumUsingDataService_basic() {
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] { 1, 2, 3 });

		assertEquals(6, business.calculateSumUsingDataService());
	}

	@Test
	void calculateSumUsingDataService_empty() {
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {});

		assertEquals(0, business.calculateSumUsingDataService());
	}

	@Test
	void calculateSumUsingDataService_oneValue() {

		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] { 5 });

		assertEquals(5, business.calculateSumUsingDataService());
	}

}
