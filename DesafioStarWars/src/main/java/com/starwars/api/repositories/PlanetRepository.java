package com.starwars.api.repositories;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.starwars.api.document.Planet;

@Repository
public interface PlanetRepository extends MongoRepository<Planet, String> {
		
	@Query(value = "{'name' : ?0}")
	Optional<Planet> findByName(String name);
		
}
