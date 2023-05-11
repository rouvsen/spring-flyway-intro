package com.rouvsen.springflywayintro;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
class TestsApplicationTests {

	@Autowired
	private MockMvc mockMvc;
	//
	@Test
	public void testPathV1Controller() throws Exception {
		mockMvc.perform(get("/api/v1/product"))
				.andExpect(status().isOk())
				.andExpect(content().json("{\n" +
						"    \"name\": \"HP Laptop\"\n" +
						"}"));
	}
	@Test
	public void testPathV2Controller() throws Exception {
		mockMvc.perform(get("/api/v2/product"))
				.andExpect(status().isOk())
				.andExpect(content().json("{\n" +
						"    \"name\": \"HP Laptop\",\n" +
						"    \"price\": 10\n" +
						"}"));
	}
	//Param
	@Test
	public void testParamV1Controller() throws Exception {
		mockMvc.perform(get("/api/param/product?apiVersion=1"))
				.andExpect(status().isOk())
				.andExpect(content().json("{\n" +
						"    \"name\": \"HP Laptop\"\n" +
						"}"));
	}
	@Test
	public void testParamV2Controller() throws Exception {
		mockMvc.perform(get("/api/param/product?apiVersion=2"))
				.andExpect(status().isOk())
				.andExpect(content().json("{\n" +
						"    \"name\": \"HP Laptop\",\n" +
						"    \"price\": 10\n" +
						"}"));
	}
	//Request Header
	@Test
	public void testHeaderV1Controller() throws Exception {
		mockMvc.perform(get("/api/header/product").header("X-API-VERSION", "1"))
				.andExpect(status().isOk())
				.andExpect(content().json("{\n" +
						"    \"name\": \"HP Laptop\"\n" +
						"}"));
	}
	@Test
	public void testHeaderV2Controller() throws Exception {
		mockMvc.perform(
			get("/api/header/product")
					.header("X-API-VERSION", "2")
		).andExpect(status().isOk())
				.andExpect(content().json("{\n" +
						"    \"name\": \"HP Laptop\",\n" +
						"    \"price\": 10\n" +
						"}"));
	}
}

