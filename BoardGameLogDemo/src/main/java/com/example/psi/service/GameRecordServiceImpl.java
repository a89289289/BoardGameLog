//package com.example.psi.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.example.psi.entity.GameRecord;
//import com.example.psi.repository.GameRecordRepository;
//
//@Service
//public class GameRecordServiceImpl implements GameRecordService {
//
//    @Autowired
//    private GameRecordRepository gameRecordRepository;
//
//    public GameRecord getGameRecordById(Long id) {
//        return gameRecordRepository.findById(id).orElse(null);
//    }
//
//    public void updateGameRecord(GameRecord newGameRecord, Long id) {
//        GameRecord existingGameRecord = gameRecordRepository.findById(id).orElse(null);
//
//        if (existingGameRecord != null) {
//            existingGameRecord.setGameName(newGameRecord.getGameName());
//            existingGameRecord.setGameDate(newGameRecord.getGameDate());
//            // 设置其他属性
//
//            // 更新数据库
//            gameRecordRepository.save(existingGameRecord);
//        }
//    }
//
//    public void performCustomLogic(GameRecord gameRecord) {
//        // 添加自定义逻辑
//        // 例如，处理游戏记录的某些特殊操作
//    }
//
//    // 其他可能的业务逻辑方法
//
//}
