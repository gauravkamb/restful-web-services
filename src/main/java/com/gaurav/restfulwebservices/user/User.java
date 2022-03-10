package com.gaurav.restfulwebservices.user;

import java.util.Date;

import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFilter;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
//@JsonFilter(value = "UserDynamicFilter")
public class User {
	
	private Integer id;
	@Size(min = 2, message = "min size 2 required")
	private String name;
	//@JsonIgnore
	private Date birthDate;

}
