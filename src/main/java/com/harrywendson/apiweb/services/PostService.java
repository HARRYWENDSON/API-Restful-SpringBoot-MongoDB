package com.harrywendson.apiweb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.harrywendson.apiweb.domain.Post;
import com.harrywendson.apiweb.repository.PostRepository;
import com.harrywendson.apiweb.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repo;

	public Post findById(String id) {
		Optional<Post> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto Id não encontrado!"));
	}

	public List<Post> findByTitle(String text) {
		return repo.searchTitle(text);
	}
}
