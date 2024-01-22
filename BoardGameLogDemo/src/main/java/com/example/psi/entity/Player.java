package com.example.psi.entity;

import org.springframework.data.relational.core.mapping.Table;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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

    @ManyToOne
    @JoinColumn(name = "game_record_id")
    private GameRecord gameRecord;

    // Getters and setters

    // Constructors
}