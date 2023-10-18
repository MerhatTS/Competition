package com.example.Competition.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
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

}
