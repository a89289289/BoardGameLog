package com.example.psi.entity;

import java.util.List;

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

  
    private String gameName;

    
    private String photo;

    
    private String textRecord;

    @OneToMany(mappedBy = "gameRecord", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Player> players;

    // 省略構造函數、getter 和 setter
}
