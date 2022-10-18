package com.harrywendson.apiweb.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.harrywendson.apiweb.domain.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<User>> findAll() {
		User key = new User("1", "keykey", "key@gmail.com");
		User nay = new User("2", "nay", "nay@gmail.com");
		User nivia = new User("3", "Nivia", "nini@gmail.com");
		List<User> list = new ArrayList<>();
		list.addAll(Arrays.asList(key, nay, nivia));
		return ResponseEntity.ok().body(list);
	}
}
