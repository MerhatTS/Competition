package com.example.Competition.Repositories;

import com.example.Competition.Entity.Roles;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface RoleRepository extends CrudRepository<Roles, Integer> {
    List<Roles> findByName(String name);
}
