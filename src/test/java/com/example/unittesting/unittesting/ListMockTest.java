package com.example.unittesting.unittesting;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

class ListMockTest {

	List<String> mock = mock(List.class);

	@Test
	public void size_basic() {
		when(mock.size()).thenReturn(5);
		assertEquals(5, mock.size());
	}

	@Test
	public void returnDifferentValues() {
		when(mock.size()).thenReturn(5).thenReturn(10);
		assertEquals(5, mock.size());
		assertEquals(10, mock.size());
	}

	@Test
	public void returnWithParameters() {
		when(mock.get(0)).thenReturn("Dummy");
		assertEquals("Dummy", mock.get(0));
		assertEquals(null, mock.get(1));
	}

	@Test
	public void returnWithGenericParameters() {
		when(mock.get(anyInt())).thenReturn("Dummy");
		assertEquals("Dummy", mock.get(0));
		assertEquals("Dummy", mock.get(1));
	}

	@Test
	public void verificationBasics() {
		// SUT
		String value1 = mock.get(0);
		String value2 = mock.get(1);

		// Verify
		verify(mock).get(0);
		verify(mock, times(2)).get(anyInt());
		verify(mock, atLeast(1)).get(anyInt());
		verify(mock, atLeastOnce()).get(anyInt());
		verify(mock, atMost(2)).get(anyInt());
		verify(mock, never()).get(2);

	}

	@Test
	public void argumentCapturing() {
		// SUT
		mock.add("SomeString");

		// Verification
		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
		verify(mock).add(captor.capture());

		assertEquals("SomeString", captor.getValue());
	}

	@Test
	public void multipleArgumentCapturing() {
		// SUT
		mock.add("SomeString1");
		mock.add("SomeString2");

		// Verification
		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
		verify(mock, times(2)).add(captor.capture());

		List<String> allValues = captor.getAllValues();
		assertEquals("SomeString1", allValues.get(0));
		assertEquals("SomeString2", allValues.get(1));

	}

	@Test
	public void mocking() {
		ArrayList arraylistMock = mock(ArrayList.class);
		System.out.println(arraylistMock.get(0));// null
		System.out.println(arraylistMock.size()); // 0
		arraylistMock.add("Test");
		arraylistMock.add("Test2");
		System.out.println(arraylistMock.size()); // 0
		when(arraylistMock.size()).thenReturn(5);
		System.out.println(arraylistMock.size());// 5

	}

	@Test
	public void spying() {
		ArrayList arraylistSpy = spy(ArrayList.class);
		arraylistSpy.add("Test0");
		System.out.println(arraylistSpy.get(0));// Test0
		System.out.println(arraylistSpy.size()); // 1
		arraylistSpy.add("Test");
		arraylistSpy.add("Test2");
		System.out.println(arraylistSpy.size()); // 3
		when(arraylistSpy.size()).thenReturn(5);
		System.out.println(arraylistSpy.size());// 5

		arraylistSpy.add("Test4");
		System.out.println(arraylistSpy.size());// 5

		verify(arraylistSpy).add("Test4");
	}
}
