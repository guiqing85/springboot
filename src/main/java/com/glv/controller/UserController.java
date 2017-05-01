package com.glv.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.glv.domain.User;

@RestController
@RequestMapping("/users")
public class UserController {

	static Map<Long, User> userMaps = Collections.synchronizedMap(new HashMap<Long, User>());

	@RequestMapping(value = "", method = RequestMethod.GET)
	public List<User> getUsers() {
		List<User> users = new ArrayList<User>(userMaps.values());
		return users;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public User getUser(@PathVariable Long id) {
		User user = userMaps.get(id);
		return user;
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	public String postUser(@RequestBody User user) {
		userMaps.put(user.getId(), user);
		return "success";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public String updateUser(@PathVariable Long id, @RequestBody User user) {
		User u = userMaps.get(id);
		u.setAge(user.getAge());
		u.setName(user.getName());
		return "success";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public String deleteUser(@PathVariable Long id) {
		userMaps.remove(id);
		return "success";
	}

}
