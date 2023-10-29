package com.example.Competition.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "teams")
public class Teams {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Integer score;
    private Integer place;

    @OneToMany(mappedBy = "team")
    private List<Players> players = new ArrayList<>();

    @Override
    public String toString() {
        return
                name;
    }
}
