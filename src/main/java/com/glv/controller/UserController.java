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

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/users")
public class UserController {

	static Map<Long, User> userMaps = Collections.synchronizedMap(new HashMap<Long, User>());

	@ApiOperation(value = "Get All Users list", notes = "")
	@RequestMapping(value = "", method = RequestMethod.GET)
	public List<User> getUsers() {
		List<User> users = new ArrayList<User>(userMaps.values());
		return users;
	}

	@ApiOperation(value = "Get User detail information", notes = "Get user detail information by user id")
	@ApiImplicitParam(name = "id", value = "user id", required = true, dataType = "Long")
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public User getUser(@PathVariable Long id) {
		User user = userMaps.get(id);
		return user;
	}

	@ApiOperation(value = "Create User", notes = "Create User by user object")
	@ApiImplicitParam(name = "user", value = "user entity", required = true, dataType = "User")
	@RequestMapping(value = "", method = RequestMethod.POST)
	public String postUser(@RequestBody User user) {
		userMaps.put(user.getId(), user);
		return "success";
	}

	@ApiOperation(value = "Update User", notes = "Update user by id")
	@ApiImplicitParams({ @ApiImplicitParam(name = "id", value = "user id", required = true, dataType = "long"),
			@ApiImplicitParam(name = "user", value = "user entity", required = true, dataType = "User")

	})
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public String updateUser(@PathVariable long id, @RequestBody User user) {
		User u = userMaps.get(id);
		u.setAge(user.getAge());
		u.setName(user.getName());
		return "success";
	}

	@ApiOperation(value = "Delete User", notes = "Delete user by user id")
	@ApiImplicitParam(name = "id", value = "user id", required = true, dataType = "Long")
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public String deleteUser(@PathVariable Long id) {
		userMaps.remove(id);
		return "success";
	}

}
