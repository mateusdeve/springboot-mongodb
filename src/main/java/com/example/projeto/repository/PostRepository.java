package com.example.projeto.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.projeto.entities.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

}
