package com.example.psi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.psi.entity.GameRecord;
import com.example.psi.repository.GameRecordRepository;
import com.example.psi.repository.PlayerJpaRepository;

@Service
public class GameService {

    @Autowired
    private GameRecordRepository gameRecordRepository;

    @Autowired
    private PlayerJpaRepository playerRepository;

    public void saveGameRecord(GameRecord gameRecord) {
        gameRecordRepository.save(gameRecord);
    }

    public Iterable<GameRecord> getAllGameRecords() {
        return gameRecordRepository.findAll();
    }
}