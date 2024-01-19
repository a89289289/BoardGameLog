package com.example.psi.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.psi.entity.Player;

public interface PlayerJpaRepository extends JpaRepository<Player, Long> {
    // 可以新增特定的查詢方法，如果有需要
}