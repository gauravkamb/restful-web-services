package com.gaurav.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningController {
	
	// version in url - different url for different version
	@GetMapping("v1/person")
	public PersonV1 person1() {
		return new PersonV1("Gaurav");
	}
	
	@GetMapping("v2/person")
	public PersonV2 person2() {
		return new PersonV2(new Name("Gaurav", "Kamble"));
	}
	
	// versioning using params, url will be same param value will be sewnt with url.. ?version=1
	@GetMapping(value = "person/param", params = "version=1")
	public PersonV1 param1() {
		return new PersonV1("Gaurav");
	}
	
	@GetMapping(value = "person/param", params = "version=2")
	public PersonV2 param2() {
		return new PersonV2(new Name("Gaurav", "Kamble"));
	}
	
	
	// versioning using headers, url will be same but header value will be different for different versions 
	@GetMapping(value = "person/header", headers = "X-API-VERSION=1")
	public PersonV1 header1() {
		return new PersonV1("Gaurav");
	}
	
	//@GetMapping(value = "person/header", headers = "X-API-VERSION=2")
	public PersonV2 header2() {
		return new PersonV2(new Name("Gaurav", "Kamble"));
	}
	
	// versioning using produces, request header accept = application/vnd.company.app-v1+json
	// same url but different produces value should be passed in accept header for different versions
	@GetMapping(value = "/person/produces", produces = "application/v1+json")
	public PersonV1 producesV1() {
		return new PersonV1("Gaurav");
	}

	@GetMapping(value = "/person/produces", produces = "application/v2+json")
	public PersonV2 producesV2() {
		return new PersonV2(new Name("Gaurav", "Kamble"));
	}

}
