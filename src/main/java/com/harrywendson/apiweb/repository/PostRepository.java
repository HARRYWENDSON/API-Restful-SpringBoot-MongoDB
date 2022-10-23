package com.harrywendson.apiweb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.harrywendson.apiweb.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

}