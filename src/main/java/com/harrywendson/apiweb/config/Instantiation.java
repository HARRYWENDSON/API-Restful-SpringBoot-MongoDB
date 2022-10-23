package com.harrywendson.apiweb.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.harrywendson.apiweb.domain.User;
import com.harrywendson.apiweb.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;
	@Override
	public void run(String... args) throws Exception {
		
		userRepository.deleteAll();
		
		User harry = new User(null, "w Harry", "harry@gmail.com");
		User key = new User(null, "key Nayara", "key@gmail.com");
		User raquel = new User(null, "raquel", "raquel@gmail.com");
		
		userRepository.saveAll(Arrays.asList(harry, key, raquel));
	}

}
