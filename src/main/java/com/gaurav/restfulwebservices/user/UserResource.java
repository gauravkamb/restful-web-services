package com.gaurav.restfulwebservices.user;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class UserResource {
	
	@Autowired
	private UserDaoService userDaoService;
	
	@GetMapping("/users")
	public List<User> findAll(){
		return userDaoService.findAll();
	}
	
	@GetMapping("/users/{id}")
	public User findUser(@PathVariable Integer id){
		User u = userDaoService.findUser(id);
		if(u == null)
			throw new UserNotFoundException("Id = " + id);
		return u;
	}
	
	@PostMapping("/users")
	public ResponseEntity<Object> addUser(@Valid @RequestBody User user) {
		User u = userDaoService.addUser(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(u.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	//skip id and birthdate field dynamically
	@GetMapping("/users/dynamic-filtering")
	public MappingJacksonValue dynamicFiltering(){
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.    filterOutAllExcept("name");
		FilterProvider provider = new SimpleFilterProvider().addFilter("UserDynamicFilter", filter);
		MappingJacksonValue mjv = new MappingJacksonValue(userDaoService.findAll());
		mjv.setFilters(provider);
		return mjv;
	}

}
