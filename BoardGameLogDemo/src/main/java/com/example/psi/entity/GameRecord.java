package com.example.psi.entity;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.relational.core.mapping.Table;
import org.springframework.web.multipart.MultipartFile;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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

	private String photo;

	private String textRecord;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "game_record_id")
	private List<Player> players;

	public void addPlayer(Player player) {
		if (players == null) {
			players = new ArrayList<>();
		}
		players.add(player);
		player.setGameRecord(this);

		// Getters and setters

		// Constructors
	}
}
