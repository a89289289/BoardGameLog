package com.example.psi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.psi.entity.GameRecord;
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

    public Iterable<GameRecord> getAllGameRecords() {
        return gameRecordRepository.findAll();
    }
}