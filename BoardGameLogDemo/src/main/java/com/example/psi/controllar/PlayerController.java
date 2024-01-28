package com.example.psi.controllar;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.psi.entity.GameRecord;
import com.example.psi.entity.Player;
import com.example.psi.service.GameService;

@RestController
@RequestMapping("/your-backend-endpoint")
public class PlayerController {

	@Autowired
	private GameService gameService; // 這裡假設有一個 GameService 用來處理遊戲相關邏輯

	@PostMapping
	public ResponseEntity<String> saveGameRecord(@RequestBody Map<String, Object> requestData) {
		try {
			// 從 requestData 中取得 gameRecord 和 players 資料
			Map<String, Object> gameRecordData = (Map<String, Object>) requestData.get("gameRecord");
			List<Map<String, Object>> playersData = (List<Map<String, Object>>) requestData.get("players");
			System.out.println(requestData);
			// 將資料轉換為對應的 Java 實體類別
			GameRecord gameRecord = mapToGameRecord(gameRecordData);
			List<Player> players = mapToPlayers(playersData);

			// 設定關聯
			for (Player player : players) {
				gameRecord.addPlayer(player);
			}

			// 儲存遊戲記錄
			gameService.saveGameRecord(gameRecord);

			return new ResponseEntity<>("Game record saved successfully", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("Error saving game record", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	private GameRecord mapToGameRecord(Map<String, Object> data) {
		GameRecord gameRecord = new GameRecord();
		gameRecord.setGameName((String) data.get("gameName"));
		gameRecord.setGameDate((String) data.get("gameDate"));
		// 其他 gameRecord 的屬性

		return gameRecord;
	}

	private List<Player> mapToPlayers(List<Map<String, Object>> dataList) {
		List<Player> players = new ArrayList<>();

		for (Map<String, Object> data : dataList) {
			Player player = new Player();
			player.setPlayerName((String) data.get("playerName"));
			player.setPlayerScore((int) data.get("playerScore"));
			player.setPlayerNote((String) data.get("playerNote"));

			players.add(player);
		}

		return players;
	}
}
