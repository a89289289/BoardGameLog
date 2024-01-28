package com.example.psi.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.data.relational.core.mapping.Table;
import org.springframework.web.multipart.MultipartFile;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta .persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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

  
    // Change the type to MultipartFile for handling file upload
    private String photo; // Assuming you have a file upload field in your form

    private String textRecord;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "player_game_record",
            joinColumns = @JoinColumn(name = "game_record_id"),
            inverseJoinColumns = @JoinColumn(name = "player_id")
    )
    private List<Player> players = new ArrayList<>();

    public void addPlayer(Player player) {
        if (players == null) {
            players = new ArrayList<>();
        }
        players.add(player);
        player.getGameRecords().add(this);
    }
    public List<Player> getPlayers() {
        return players;
    }
    // Getters and setters

    // Constructors
}