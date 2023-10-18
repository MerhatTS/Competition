package com.example.Competition.Repositories;

import com.example.Competition.Entity.Players;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PlayerRepository extends CrudRepository<Players, Integer> {
    @Query(value = "from Players p order by p.name")
    List<Players> findAll();
}
