package com.example.psi.service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.hibernate.mapping.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.psi.entity.GameRecord;
import com.example.psi.entity.Player;
import com.example.psi.repository.GameRecordRepository;

@Service
public class GameRecordService {

    @Autowired
    private GameRecordRepository gameRecordRepository;

    @Transactional
    public void saveGameRecord(GameRecord gameRecord) {
        gameRecordRepository.save(gameRecord);
    }

    public Iterable<GameRecord> getAllGameRecords() {
        return gameRecordRepository.findAll();
    }

    public Map<String, Long> countGamePlayTimes() {
        List<Object[]> playTimesData = gameRecordRepository.countGamePlayTimes();
        Map<String, Long> gamePlayTimes = new HashMap<>();

        for (Object[] data : playTimesData) {
            String gameName = (String) data[0];
            Long playTimes = (Long) data[1];
            gamePlayTimes.put(gameName, playTimes);
        }

        return gamePlayTimes;
    }

//
    public GameRecord getGameRecordById(Long id) {
        return gameRecordRepository.findById(id).orElse(null);
    }

//   
    @Transactional
    public void updateGameRecord(GameRecord newGameRecord, Long id) {
        Optional<GameRecord> existingGameRecordOpt = gameRecordRepository.findById(id);
        existingGameRecordOpt.ifPresent(existingGameRecord -> {
            // 更新现有记录的属性
            existingGameRecord.setGameName(newGameRecord.getGameName());
            existingGameRecord.setGameDate(newGameRecord.getGameDate());
            // 设置其他属性

            // 保存回数据库
            gameRecordRepository.save(existingGameRecord);
        });
    } 
//刪除
    public void deleteGameRecord(Long id) {
    	Optional<GameRecord> gameRecordOpt = gameRecordRepository.findById(id);
    	if (gameRecordOpt.isPresent()) {
			gameRecordRepository.delete(gameRecordOpt.get());
		}
    	
        
    }
    
   
}