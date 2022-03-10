package com.gaurav.restfulwebservices.user;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
//@JsonFilter(value = "UserDynamicFilter")
@Entity
public class User {
	
	@Id
	@GeneratedValue
	private Integer id;
	@Size(min = 2, message = "min size 2 required")
	private String name;
	//@JsonIgnore
	private Date birthDate;
	
	@OneToMany(mappedBy = "user")
	private List<Post> posts;

}
