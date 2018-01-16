package com.BaltaJuanTesis.demoBoot.repository;

import org.springframework.data.repository.CrudRepository;

import com.BaltaJuanTesis.demoBoot.modelo.User;


public interface UserRepository extends CrudRepository<User, Long> {

	User findByUsername(String name);
}