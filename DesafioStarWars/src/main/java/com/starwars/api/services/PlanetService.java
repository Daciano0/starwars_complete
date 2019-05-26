package com.starwars.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.starwars.api.document.Planet;

@Service
public interface PlanetService {

	List<Planet> listPlanets();
	
	Optional<Planet> findById(String id);
	
	Optional<Planet> findByName(String name);
	
	Planet register(Planet planet);
	
	Planet update(Planet planet);
	
	void remove(String id);
	
}
