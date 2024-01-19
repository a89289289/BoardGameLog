package com.example.psi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.psi.entity.GameRecord;

public interface GameRecordRepository extends JpaRepository<GameRecord, Long> {
    // 可以新增特定的查詢方法，如果有需要
}