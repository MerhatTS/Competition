package com.example.Competition.Repositories;

import com.example.Competition.Entity.Players;
import com.example.Competition.Entity.Schedule;
import com.example.Competition.Entity.Teams;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PlayerRepository extends CrudRepository<Players, Integer> {
    @Query(value = "from Players p order by p.name")
    List<Players> findAll();
    @Query(value = "from Teams")
    List<Teams> teamsAll();

    @Query(value = "from Schedule")
    List<Schedule> scheduleAll();

    @Query(value = "from Players p where p.user_id = :user_id")
    Optional<Players> findByUserId(@Param("user_id") Integer userId);

}
