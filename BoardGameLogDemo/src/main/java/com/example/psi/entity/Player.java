package com.example.psi.entity;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Hibernate;
import org.springframework.data.relational.core.mapping.Table;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
    

    public Player(String playerName, int playerScore, String playerNote) {
        this.playerName = playerName;
        this.playerScore = playerScore;
        this.playerNote = playerNote;
    }
    
 // 新增的无参数构造函数
    public Player() {
        // JPA 需要的默认构造函数
    }

    
    
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "player_game_record",
        joinColumns = @JoinColumn(name = "player_id"),
        inverseJoinColumns = @JoinColumn(name = "game_record_id")
    )
    private Set<GameRecord> gameRecords = new HashSet<>();

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