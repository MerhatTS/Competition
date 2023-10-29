package com.example.Competition.Repositories;

import com.example.Competition.Entity.Players;
import com.example.Competition.Entity.Schedule;
import com.example.Competition.Entity.Teams;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PlayerRepository extends CrudRepository<Players, Integer> {
    @Query(value = "from Players p order by p.name")
    List<Players> findAll();
    @Query(value = "from Teams")
    List<Teams> teamsAll();

    @Query(value = "from Schedule")
    List<Schedule> scheduleAll();
}
