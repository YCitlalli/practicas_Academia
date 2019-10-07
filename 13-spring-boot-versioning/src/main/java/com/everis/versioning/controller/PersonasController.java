package com.everis.versioning.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.everis.versioning.model.PersonaV1;
import com.everis.versioning.model.PersonaV2;

@RestController
public class PersonasController {

	//Versionamiento por URI -Twitter
	@GetMapping("/v1/persona")
	public PersonaV1 personaV1() {
		return new PersonaV1("Citlalli Rivera");
	}
	
	@GetMapping("/v2/persona")
	public PersonaV2 personaV2() {
		return new PersonaV2("Citlalli", "Rivera", "Diaz");
	}
	
	//QueryString -> Amazon
	@GetMapping(value="/persona/param", params="version=1")
	public PersonaV1 personaParamV1() {
		return new PersonaV1("Citlalli Rivera");
	}
	
	@GetMapping(value="/persona/param", params="version=2")
	public PersonaV2 personaParamV2() {
		return new PersonaV2("Citlalli", "Rivera", "Diaz");
	}
	
	//Headers -> Microsoft
	//Se ejecuta por medio de Postman
	@GetMapping(value="/persona/header", headers="X-API-VERSION=1")
	public PersonaV1 personaHeaderV1() {
		return new PersonaV1("Citlalli Rivera");
	}
	
	@GetMapping(value="/persona/header", headers="X-API-VERSION=2")
	public PersonaV2 personaHeaderV2() {
		return new PersonaV2("Citlalli", "Rivera", "Diaz");
	}
	
	//MediaType es como se estila en -> GitHub
	@GetMapping(value="/persona/mediatype", produces = "application/vnd.com.everis.app-v1+json")
	public PersonaV1 personaMediaTypeV1() {
		return new PersonaV1("Citlalli Rivera");
	}
	
	
	@GetMapping(value="/persona/mediatype", produces = "application/vnd.com.everis.app-v2+json")
	public PersonaV2 personaMediaTypeV2() {
		return new PersonaV2("Citlalli", "Rivera", "Diaz");
	}
	
	
}
