//package com.example.psi.model;
//
//import com.example.psi.entity.GameRecord;
//import com.example.psi.entity.Player;
//import com.example.psi.repository.GameRecordRepository;
//import com.example.psi.repository.PlayerRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Component
//public class DataInitializer implements CommandLineRunner {
//
//    @Autowired
//    private GameRecordRepository gameRecordRepository;
//
//    @Autowired
//    private PlayerRepository playerRepository;
//
//    @Override
//    public void run(String... args) throws Exception {
//        for (int i = 1; i <= 2; i++) {
//            // 创建一个GameRecord对象
//            GameRecord gameRecord = new GameRecord();
//            gameRecord.setGameName("Game " + i);
//            gameRecord.setGameDate("2024-01-22");
//            gameRecord.setTextRecord("Example text record for Game " + i);
//
//            // 保存GameRecord到数据库
//            gameRecordRepository.save(gameRecord);
//
//            // 创建并保存4个Player对象，每个GameRecord关联4个Player
//            for (int j = 1; j <= 4; j++) {
//                Player player = new Player();
//                player.setPlayerName("Player " + (i * 4 + j));
//                player.setPlayerScore((int) (Math.random() * 100)); // 随机分数
//                player.setPlayerNote("Note for Player " + (i * 4 + j));
//                player.setGameRecord(gameRecord); // 设置关联
//
//                // 保存Player到数据库
//                playerRepository.save(player);
//            }
//        }
//    }
//}
