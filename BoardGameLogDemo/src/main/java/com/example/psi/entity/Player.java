package com.example.psi.entity;

import java.util.Set;

import org.springframework.data.relational.core.mapping.Table;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;  // 修改这里
import lombok.Data;  

@Data
@Entity
@Table(name = "players")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String playerName;
    private int playerScore;
    private String playerNote;

    @OneToMany  // 修改这里
    @JoinColumn(name = "player_id")  // 指定外键列的名称
    private Set<GameRecord> gameRecords;

    // Getters and setters

    // Constructors
}