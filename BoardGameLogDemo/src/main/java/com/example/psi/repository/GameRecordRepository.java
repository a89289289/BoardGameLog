package com.example.psi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.psi.entity.GameRecord;

public interface GameRecordRepository extends JpaRepository<GameRecord, Long> {

	// 获取游戏遊玩次數数据
	@Query("SELECT g.gameName, COUNT(g) FROM GameRecord g GROUP BY g.gameName")
	List<Object[]> countGamePlayTimes();

	// 获取游戏日期統計数据
	@Query("SELECT gr.gameDate, COUNT(gr) FROM GameRecord gr GROUP BY gr.gameDate")
	List<Object[]> getGameDateData();

	@Query("SELECT g.gameName, COUNT(g) FROM GameRecord g GROUP BY g.gameName")
	List<Object[]> countGamePlays();

	List<GameRecord> findByGameNameContaining(String term);

	@Query("SELECT g FROM GameRecord g JOIN FETCH g.players")
	List<GameRecord> findAllWithPlayers();
}
