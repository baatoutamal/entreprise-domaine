package com.esprit.microservice.repository;

import org.springframework.data.repository.CrudRepository;

import com.esprit.microservice.entity.User;

public interface UserRepository extends CrudRepository<User, Integer> {
    User findByUsername(String username);
}
