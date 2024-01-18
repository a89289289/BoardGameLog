package com.example.psi.service;

import com.example.psi.entity.GameRecord;

public interface GameRecordService {
    void saveGameRecord(GameRecord gameRecord);
    // 可以添加其他相關的資料庫交互方法
}
