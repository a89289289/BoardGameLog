package com.example.psi.repository;

import com.example.psi.entity.GameRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRecordRepository extends JpaRepository<GameRecord, Long> {
    // 可以添加其他需要的查詢方法
}
