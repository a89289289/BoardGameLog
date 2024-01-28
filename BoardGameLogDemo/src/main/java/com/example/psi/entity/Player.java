package com.example.psi.entity;

import java.util.HashSet;
import java.util.Set;

import org.springframework.data.relational.core.mapping.Table;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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

    @ManyToMany
    @JoinTable(
            name = "player_game_record",
            joinColumns = @JoinColumn(name = "player_id"),
            inverseJoinColumns = @JoinColumn(name = "game_record_id")
    )
    private Set<GameRecord> gameRecords;

    // 新增的方法
    public void setGameRecord(GameRecord gameRecord) {
        if (gameRecords == null) {
            gameRecords = new HashSet<>();
        }
        gameRecords.add(gameRecord);
        gameRecord.getPlayers().add(this);
    }
    // Getters and setters

    // Constructors
}