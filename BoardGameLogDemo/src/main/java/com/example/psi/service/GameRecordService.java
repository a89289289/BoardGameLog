package com.example.psi.service;

import com.example.psi.entity.GameRecord;
import com.example.psi.repository.GameRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameRecordService {

    @Autowired
    private GameRecordRepository gameRecordRepository;

    public List<GameRecord> getAllGameRecords() {
        return gameRecordRepository.findAll();
    }

    public void saveGameRecord(GameRecord gameRecord) {
        gameRecordRepository.save(gameRecord);
    }
}
