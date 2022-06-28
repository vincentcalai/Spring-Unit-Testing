package com.example.unittesting.unittesting.spike;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class AssertJTest {

	@Test
	void learning() {
		List<Integer> numbers = Arrays.asList(12, 15, 45);

//		assertThat(numbers, hasSize(3));
//		assertThat(numbers, hasItems(12, 45));
//		assertThat(numbers, everyItem(greaterThan(10)));
//		assertThat(numbers, everyItem(lessThan(100)));
		assertThat(numbers).hasSize(3).contains(12, 45).allMatch(x -> x > 10).allMatch(x -> x < 100)
				.noneMatch(x -> x < 0);

//		assertThat("", isEmptyString());
		assertThat("").isEmpty();

//		assertThat("ABCDE", containsString("BCD"));
//		assertThat("ABCDE", startsWith("ABC"));
//		assertThat("ABCDE", endsWith("CDE"));
		assertThat("ABCDE").contains("BCD").startsWith("ABC").endsWith("CDE");

	}

}
