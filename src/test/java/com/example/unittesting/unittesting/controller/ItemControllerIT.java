package com.example.unittesting.unittesting.controller;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class ItemControllerIT {

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void contextLoads() throws JSONException {
		String response = this.restTemplate.getForObject("/all-items-from-database", String.class);
		JSONAssert.assertEquals("[{id: 10001, name: Item1}, {id: 10002, name: Item2}, {id: 10003, name: Item3}]",
				response, false);
	}

}
