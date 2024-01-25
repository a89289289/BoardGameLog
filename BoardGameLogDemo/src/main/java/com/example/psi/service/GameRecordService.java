package com.example.psi.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.psi.entity.GameRecord;
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
}