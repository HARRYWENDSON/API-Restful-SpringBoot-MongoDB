package com.harrywendson.apiweb.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.harrywendson.apiweb.domain.Post;
import com.harrywendson.apiweb.domain.User;
import com.harrywendson.apiweb.dto.AuthorDTO;
import com.harrywendson.apiweb.dto.CommentDTO;
import com.harrywendson.apiweb.repository.PostRepository;
import com.harrywendson.apiweb.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User harry = new User(null, "w Harry", "harry@gmail.com");
		User key = new User(null, "key Nayara", "key@gmail.com");
		User raquel = new User(null, "raquel", "raquel@gmail.com");
		userRepository.saveAll(Arrays.asList(harry, key, raquel));
		
		Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar para PHO. Abraços!", new AuthorDTO(key));
		Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom Dia", "Acordei feliz hoje!", new AuthorDTO(key));
		
		CommentDTO c1 = new CommentDTO("Boa viagem bb!", sdf.parse("21/03/2018"), new AuthorDTO(raquel));
		CommentDTO c2 = new CommentDTO("Quem deixou!", sdf.parse("22/03/2018"), new AuthorDTO(harry));
		CommentDTO c3 = new CommentDTO("Tenha um ótimo dia!", sdf.parse("23/03/2018"), new AuthorDTO(harry));
		
		post1.getComments().addAll(Arrays.asList(c1, c2));
		post2.getComments().addAll(Arrays.asList(c3));
		
		postRepository.saveAll(Arrays.asList(post1, post2));
		
		key.getPosts().addAll(Arrays.asList(post1,post2));
		userRepository.save(key);
	}

}
