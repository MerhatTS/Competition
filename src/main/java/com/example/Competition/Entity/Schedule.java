package com.example.Competition.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "schedule")
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Date date;

    @OneToOne
    @JoinColumn(name = "first_team")
    private Teams firstTeam;

    @OneToOne
    @JoinColumn(name = "second_team")
    private Teams secondTeam;

    @Override
    public String toString() {
        return "Schedule{" +
                "id=" + id +
                ", date=" + date +
                ", firstTeam=" + firstTeam +
                ", secondTeam=" + secondTeam +
                '}';
    }
}
