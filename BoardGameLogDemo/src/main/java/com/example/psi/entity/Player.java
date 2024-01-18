package com.example.psi.entity;

import org.springframework.data.relational.core.mapping.Column;
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

    @ManyToOne
    @JoinColumn(name = "game_record_id")
    private GameRecord gameRecord;

    @Column(value = "player_name")
    private String playerName;

    @Column(value = "player_score")
    private Integer playerScore;

    @Column(value = "player_note")
    private String playerNote;

    // 省略构造函数、getter 和 setter
}
