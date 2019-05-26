package com.starwars.api.document;

import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Planet {

	@Id
	private String id;
	@NotEmpty(message = "Name cannot be empty") 
	private String name;
	@NotEmpty(message = "climate cannot be empty") 
	private String climate;
	@NotEmpty(message = "Terrain cannot be empty") 
	private String terrain;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
	public String getName() {
		return name;
	}
	
	
	public void setName(String name) {
		this.name = name;
	}
	public String getClimate() {
		return climate;
	}
	
	public void setClimate(String climate) {
		this.climate = climate;
	}
	public String getTerrain() {
		return terrain;
	}
	
	public void setTerrain(String terrain) {
		this.terrain = terrain;
	}
	
	
	
	
	
	
	
	
}
