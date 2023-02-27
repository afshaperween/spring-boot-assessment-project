package com.springboot.Crud.Application.For.Springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.Crud.Application.For.Springboot.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
