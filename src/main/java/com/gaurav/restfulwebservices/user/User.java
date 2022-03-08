package com.gaurav.restfulwebservices.user;

import java.util.Date;

import javax.validation.constraints.Size;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {
	
	private Integer id;
	@Size(min = 2, message = "min size 2 required")
	private String name;
	private Date birthDate;

}
