package com.starwars.api.response;

import java.util.List;

public class Response<T> {

	private T planetDB;
	private List<String> erros;
	private Object[] planetsAPI;
	
	public Response(T planetDB) {
		this.planetDB = planetDB;
	}
	
	public Response(List<String> erros) {
		this.erros = erros;
	}

	public Response(Object[] planetsAPI) {
		this.planetsAPI = planetsAPI;
	}

	public T getPlanetDB() {
		return planetDB;
	}

	public void setPlanetDB(T planetDB) {
		this.planetDB = planetDB;
	}

	public List<String> getErros() {
		return erros;
	}

	public void setErros(List<String> erros) {
		this.erros = erros;
	}

	public Object[] getPlanetsAPI() {
		return planetsAPI;
	}

	public void setPlanetsAPI(Object[] planetsAPI) {
		this.planetsAPI = planetsAPI;
	}

	
	
}
