package com.example.psi.entity;

import java.util.List;

import org.springframework.data.relational.core.mapping.Column;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class GameRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(value = "game_name")
    private String gameName;

    @OneToMany(mappedBy = "gameRecord", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Player> players;

    @Column(value = "photo")
    private String photo;

    @Column(value = "text_record")
    private String textRecord;

    // 省略構造函數、getter 和 setter
}
