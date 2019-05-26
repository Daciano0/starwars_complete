package com.starwars.api.controllers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PlanetControllerTest {

	@Autowired
	private PlanetController planetController;
	
	private MockMvc mockMvc;
	
	
	@Test
	public void testListPlanetsAPI() throws Exception {
		
		
		this.mockMvc.perform(MockMvcRequestBuilders.get("/api/planetsAPI")).andExpect(status().isOk());
		
	}
	
	@Test
	public void testListPlanetsDB() throws Exception {
		
		
		this.mockMvc.perform(MockMvcRequestBuilders.get("/api/planetsDB")).andExpect(status().isOk());
		
	}
	
	
	
	@Before
	public void setUp() {
		this.mockMvc = MockMvcBuilders.standaloneSetup(planetController).build();
	}
	
	
	
}
