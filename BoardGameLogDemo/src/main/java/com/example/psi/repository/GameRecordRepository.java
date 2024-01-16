package com.example.psi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.psi.entity.GameRecord;

public interface GameRecordRepository extends JpaRepository<GameRecord, Long> {
}
