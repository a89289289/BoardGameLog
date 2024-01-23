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
//        // 在這裡添加你的預先注入數據的邏輯
//
//        for (int i = 1; i <= 5; i++) {
//            // 創建一個GameRecord對象
//            GameRecord gameRecord = new GameRecord();
//            gameRecord.setGameName("Game " + i);
//            gameRecord.setGameDate("2024-01-22");
////            gameRecord.setPhoto("example.jpg");
//            gameRecord.setTextRecord("Example text record for Game " + i);
//
//            // 創建4個Player對象
//            List<Player> players = new ArrayList<>();
//            for (int j = 1; j <= 3; j++) {
//                players.add(new Player());
//            }
//
//            gameRecord.setPlayers(players);
//
//            // 將GameRecord和相應的Player保存到數據庫
//            gameRecordRepository.save(gameRecord);
//            playerRepository.saveAll(players);
//        }
//    }
//}
