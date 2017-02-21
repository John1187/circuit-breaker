package com.java.user.client;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserClientService {

	private final RestTemplate restTemplate;
	static Map<Integer, String> userMap = new HashMap<Integer, String>();
	ObjectMapper mapper = new ObjectMapper();

	private final static String jString1 = "{" + "\"id\": \"123456789\"," + "\"name\": \"Keri Lee\","
			+ "\"age\" : \"32\"," + "\"sex\" : \"Male\"," + "\"address\" : \"20401 N 19th Avenue\"" + "}";
	private final static String jString2 = "{" + "\"id\": \"123456001\"," + "\"name\": \"Dollie R. Schnidt\","
			+ "\"age\" : \"35\"," + "\"sex\" : \"Male\"," + "\"address\" : \"20654 N 56th Avenue\"" + "}";
	private final static String jString3 = "{" + "\"id\": \"123456002\"," + "\"name\": \"Cornelia J. LeClerc\","
			+ "\"age\" : \"32\"," + "\"sex\" : \"Female\"," + "\"address\" : \"44444 N 19th Avenue\"" + "}";

	public UserClientService(RestTemplate rest) {
		this.restTemplate = rest;
		userMap.put(1, jString1);
		userMap.put(2, jString2);
		userMap.put(3, jString3);
	}

	// @HystrixCommand(fallbackMethod = "getUserCache")
	// @HystrixProperty(name =
	// "hystrix.command.default.execution.timeout.enabled", value = "false")

	@HystrixCommand(fallbackMethod = "getUserCache")
	public String getUser(int id) {
		URI uri = URI.create("http://localhost:4444/v1/user/" + id);
		return this.restTemplate.getForObject(uri, String.class);
	}

	public String getUserCache(int id) {
		String userDetails = userMap.get(id);
		if (userDetails == null) {
			userDetails = "Data not available";
		}
		return userDetails;

	}

	public String convertToJson(User user) throws JsonProcessingException {

		String userDetailsJson = null;

		userDetailsJson = mapper.writeValueAsString(user);

		return userDetailsJson;
	}

}
