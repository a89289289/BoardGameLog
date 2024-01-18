package com.example.psi.service;

import com.example.psi.entity.GameRecord;
import com.example.psi.repository.GameRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameRecordServiceImpl implements GameRecordService {

    @Autowired
    private GameRecordRepository gameRecordRepository;

    @Override
    public void saveGameRecord(GameRecord gameRecord) {
        gameRecordRepository.save(gameRecord);
    }
}
