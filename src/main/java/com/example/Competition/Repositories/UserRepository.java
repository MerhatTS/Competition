package com.example.Competition.Repositories;

import com.example.Competition.Entity.Users;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<Users, Integer> {
    Optional<Users> findByLogin(String login);
}
