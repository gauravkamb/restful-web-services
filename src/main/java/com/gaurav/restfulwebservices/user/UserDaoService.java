package com.gaurav.restfulwebservices.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
	private static List<User> userlist = new ArrayList<>();
	private static int userIdCount = 4;
	
	static {
		userlist.add(new User(1, "A", new Date(),null));
		userlist.add(new User(2, "B", new Date(),null));
		userlist.add(new User(3, "C", new Date(),null));
		userlist.add(new User(4, "D", new Date(),null));
	}
	
	public List<User> findAll(){
		return userlist;
	}
	
	public User findUser(int id) {
		for (User user : userlist) {
			if(user.getId() == id ) {
				return user;
			}
		}
		return null;
	}
	
	public User addUser(User user) {
		if(user.getId() == null) {
			user.setId(++userIdCount);
		}
		userlist.add(user);
		return user;
	}
}
