package com.example.Competition.Repositories;

import com.example.Competition.Entity.Players;
import com.example.Competition.Entity.Schedule;
import org.springframework.data.repository.CrudRepository;

public interface ScheduleRepository extends CrudRepository<Schedule, Integer> {
}
