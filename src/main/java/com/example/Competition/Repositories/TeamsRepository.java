package com.example.Competition.Repositories;

import com.example.Competition.Entity.Players;
import com.example.Competition.Entity.Teams;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TeamsRepository extends CrudRepository<Teams, Integer> {

}
