package com.example.Competition.Entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@Getter
@Setter
@Data @AllArgsConstructor @NoArgsConstructor
@Entity
@Table(name = "players")
public class Players {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Integer age;
    private String gender;
    private BigDecimal height;
    private BigDecimal weight;
    private String info;
    private Boolean accepted;

    @OneToOne
    @JoinColumn(name = "user_id")
    private Users users;

    @ManyToOne
    @JoinTable(
            name = "team_players",
            joinColumns = {@JoinColumn(name = "team_id")},
            inverseJoinColumns = {@JoinColumn(name = "player_id")}
    )
    private Teams team;



}
