package com.starwars.api.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.starwars.api.document.Planet;
import com.starwars.api.document.StarWars;
import com.starwars.api.response.Response;
import com.starwars.api.services.PlanetService;


@RestController
@RequestMapping(path = "/api")
public class PlanetController {

	@Autowired
	private PlanetService planetService;
	
	@GetMapping(path = "/planetsDB")
	public ResponseEntity<Response<List<Planet>>> listPlanets(){
		
		return ResponseEntity.ok(new Response<List<Planet>>(this.planetService.listPlanets()));
				
	}
	
	
	@GetMapping(path = "/planetsAPI")
	public ResponseEntity<Response<ResponseEntity<StarWars>>> listPlanetsAPI(){
		
		RestTemplate planetsJson = new RestTemplate();
		 HttpHeaders headers = new HttpHeaders();
         headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
         headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
         HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
	
         List<StarWars> planetsFull = new  ArrayList<StarWars>();
		
         ResponseEntity<StarWars> planets = null;
         
         int count = 1;
		
			do {
				
			planets = planetsJson.exchange("https://swapi.co/api/planets/?page="+count, HttpMethod.GET, entity, StarWars.class );
			
			if(planets.getBody().getNext() != null) {
				planetsFull.add(planets.getBody());
			}
			
			count++;
			}while(planets.getBody().getNext() != null);
	
		return ResponseEntity.ok(new Response<ResponseEntity<StarWars>>(planetsFull.toArray()));
				
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<Response<Optional<Planet>>> findById(@PathVariable(name = "id") String id){
		
		return ResponseEntity.ok(new Response<Optional<Planet>>(this.planetService.findById(id)));
	}
	
	@GetMapping(path = "/search/{name}")
	public ResponseEntity<Response<Optional<Planet>>> findByName(@PathVariable(name = "name") String name){
		
		
		return ResponseEntity.ok(new Response<Optional<Planet>>(this.planetService.findByName(name)));
	}
	

	
	@PostMapping
	public ResponseEntity<Response<Planet>> register(@Valid @RequestBody Planet planet, BindingResult result){
		
		if(result.hasErrors()) {
			List<String> erros = new ArrayList<>();
			
			result.getAllErrors().forEach(erro -> erros.add(erro.getDefaultMessage()));
			
			return ResponseEntity.badRequest().body(new Response<Planet>(erros));
		}
		
		return ResponseEntity.ok(new Response<Planet>(this.planetService.register(planet)));
	}
	
	@PutMapping(path = "/{id}")
	public ResponseEntity<Response<Planet>> update(@PathVariable(name = "id") String id, @Valid  @RequestBody Planet planet, BindingResult result){
		
		if(result.hasErrors()) {
			List<String> erros = new ArrayList<>();
			
			result.getAllErrors().forEach(erro -> erros.add(erro.getDefaultMessage()));
			
			return ResponseEntity.badRequest().body(new Response<Planet>(erros));
		}
			
		planet.setId(id);
		return ResponseEntity.ok(new Response<Planet>(this.planetService.update(planet)));
		
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Response<Integer>> remove(@PathVariable(name = "id") String id){
		this.planetService.remove(id);
		return ResponseEntity.ok(new Response<Integer>(1));
	}
	
	
}
