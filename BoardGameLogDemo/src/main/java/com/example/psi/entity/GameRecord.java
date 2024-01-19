package com.example.psi.entity;

import java.util.List;

import org.springframework.data.relational.core.mapping.Table;
import org.springframework.web.multipart.MultipartFile;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
@Table(name = "game_records")
public class GameRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String gameName;
    private String gameDate;
    private String photo; // MultipartFile
    private String textRecord;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gameRecord")
    private List<Player> players;

    // Getters and setters

    // Constructors
}