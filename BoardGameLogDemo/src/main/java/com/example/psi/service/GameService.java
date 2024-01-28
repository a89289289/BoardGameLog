package com.example.psi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.psi.entity.GameRecord;
import com.example.psi.entity.Player;
import com.example.psi.repository.GameRecordRepository;
import com.example.psi.repository.PlayerRepository;

@Service
public class GameService {

    @Autowired
    private GameRecordRepository gameRecordRepository;

   
    @Autowired
    private PlayerRepository playerRepository;

    public void saveGameRecord(GameRecord gameRecord) {
        gameRecordRepository.save(gameRecord);
    }
    
    public void savePlayer(Player player) {
        // 在这里添加保存或其他逻辑
        playerRepository.save(player);
    }

    public void savePlayers(List<Player> players) {
        // 处理从前端接收到的玩家数据
        for (Player player : players) {
            // 执行保存或其他逻辑
            savePlayer(player);
        }
    }
    
    public Iterable<GameRecord> getAllGameRecords() {
        return gameRecordRepository.findAll();
    }
// // 获取游戏遊玩次數数据
//    public List<Object[]> getGamePlayData() {
//        // 在这里添加逻辑，从数据库中获取游戏遊玩次數数据，返回格式应为 List<Object[]>
//        // 每个 Object[] 包含游戏名和遊玩次數
//        return gameRecordRepository.getGamePlayData();
//    }
//
//    // 获取游戏日期統計数据
//    public List<Object[]> getGameDateData() {
//        // 在这里添加逻辑，从数据库中获取游戏日期統計数据，返回格式应为 List<Object[]>
//        // 每个 Object[] 包含日期和遊戲次數
//        return gameRecordRepository.getGameDateData();
//    }
}