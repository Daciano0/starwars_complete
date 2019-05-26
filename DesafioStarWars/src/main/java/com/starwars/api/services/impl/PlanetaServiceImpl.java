package com.starwars.api.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.starwars.api.document.Planet;
import com.starwars.api.repositories.PlanetRepository;
import com.starwars.api.services.PlanetService;

@Service
public class PlanetaServiceImpl implements PlanetService {

	@Autowired
	private PlanetRepository planetRepository;

	@Override
	public List<Planet> listPlanets() {
		
		return this.planetRepository.findAll();
	}

	@Override
	public Optional<Planet> findById(String id) {
		
		return this.planetRepository.findById(id);
	}

	@Override
	public Optional<Planet> findByName(String name) {
		
		return this.planetRepository.findByName(name);
	}

	@Override
	public Planet register(Planet planet) {
		
		return this.planetRepository.save(planet);
	}

	@Override
	public Planet update(Planet planet) {
		
		return this.planetRepository.save(planet);
	}

	@Override
	public void remove(String id) {
		
		this.planetRepository.deleteById(id);
		
	}
	
	

}
