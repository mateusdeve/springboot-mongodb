package com.example.projeto.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.projeto.entities.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

}
