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

//	@Column(value = "photo_path")
//	private String photoPath; // 存儲文件路徑
//
//	// 修改 setPhotoFile 方法，處理文件上傳並將文件路徑保存到 photoPath 中
//	public void setPhotoFile(MultipartFile photoFile) {
//		this.photoFile = photoFile;
//		if (photoFile != null && !photoFile.isEmpty()) {
//			String fileName = StringUtils.cleanPath(photoFile.getOriginalFilename());
//
//			String uploadDir = "../static/image";
//			Path uploadPath = Paths.get(uploadDir);
//			if (!uploadPath.toFile().exists()) {
//				uploadPath.toFile().mkdirs();
//			}
//
//			String filePath = uploadDir + "/" + fileName;
//
//			// 實際保存文件
//			// 這裡需要你的業務邏輯，例如使用文件存儲服務，保存到磁盤上等等
//			// 此處僅作示例，實際上儲存應該使用文件存儲服務或其他合適的方法
//			// 例如: Files.copy(photoFile.getInputStream(), Paths.get(filePath),
//			// StandardCopyOption.REPLACE_EXISTING);
//
//			// 將文件路徑保存到 photoPath 中
//			this.photoPath = "/image/" + fileName; // 在這個例子中，我們將路徑保存為相對於靜態資源的路徑
//		}
//	}

	private String textRecord;
	
	 public GameRecord(String gameName, String gameDate, String textRecord) {
	        this.gameName = gameName;
	        this.gameDate = gameDate;
	        this.textRecord = textRecord;
	    }
	 
	 // 新增的默認構造函數
	    public GameRecord() {
	        // JPA 需要的默認構造函數
	    }

	@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
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