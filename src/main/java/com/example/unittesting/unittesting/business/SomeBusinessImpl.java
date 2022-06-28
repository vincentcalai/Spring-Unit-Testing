package com.example.unittesting.unittesting.business;

import java.util.Arrays;

import com.example.unittesting.unittesting.data.SomeDataService;

public class SomeBusinessImpl {

	SomeDataService someDataService;

	public void setSomeDataService(SomeDataService someDataService) {
		this.someDataService = someDataService;
	}

	public int calculateSum(int[] data) {

		return Arrays.stream(data).reduce(Integer::sum).orElse(0);
	}

	public int calculateSumUsingDataService() {
		int sum = 0;
		int[] data = someDataService.retrieveAllData();

		return Arrays.stream(data).reduce(Integer::sum).orElse(0);
	}

}
