package com.example.psi.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.psi.entity.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
    // 可以新增特定的查詢方法，如果有需要
}