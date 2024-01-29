package com.example.psi.entity;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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
//    private String photo; // Assuming you have a file upload field in your form

	// 不要直接將 MultipartFile 放入實體，而是將文件路徑存儲在數據庫中
	// 表示該屬性不會映射到數據庫
	@Transient
	private String photoFile; // 用於接收文件上傳

	private String textRecord;

	public GameRecord(String gameName, String gameDate, String textRecord) {
		this.gameName = gameName;
		this.gameDate = gameDate;
		this.textRecord = textRecord;
	}

	public GameRecord() {
	}

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "player_game_record", joinColumns = @JoinColumn(name = "game_record_id"), inverseJoinColumns = @JoinColumn(name = "player_id"))
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