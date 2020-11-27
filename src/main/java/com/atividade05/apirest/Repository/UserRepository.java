package com.atividade05.apirest.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atividade05.apirest.Model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
User findByUsername(String username);
}
