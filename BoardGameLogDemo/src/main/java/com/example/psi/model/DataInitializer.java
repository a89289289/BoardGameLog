//package com.example.psi.model;
//
//import java.util.Arrays;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.example.psi.entity.GameRecord;
//import com.example.psi.entity.Player;
//import com.example.psi.repository.GameRecordRepository;
//import com.example.psi.repository.PlayerRepository;
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
//        initializeGameRecords();
//        initializePlayers();
//        assignPlayersToGames();
//    }
//
//    private void initializeGameRecords() {
//        List<GameRecord> gameRecords = Arrays.asList(
//                new GameRecord("卡坦島", "2023-12-15", "這次建立了一個強大的資源帝國"),
//                new GameRecord("動物之森", "2023-12-30", "打造了一個夢幻的島嶼"),
//                new GameRecord("奇蹟時代", "2023-12-25", "發展了一個繁榮的文明"),
//                new GameRecord("動物之森", "2023-12-30", "打造了一個夢幻的島嶼"),
//                new GameRecord("抵抗組織", "2024-01-05", "成功推翻敵對政權"),
//                new GameRecord("動物之森", "2023-12-30", "打造了一個夢幻的島嶼"),
//                new GameRecord("動物之森", "2023-12-30", "打造了一個夢幻的島嶼"),
//                new GameRecord("卡坦島", "2023-12-15", "這次建立了一個強大的資源帝國"),
//                new GameRecord("卡坦島", "2023-12-15", "這次建立了一個強大的資源帝國")
//              
//        );
//
//        gameRecordRepository.saveAll(gameRecords);
//    }
//
//    private void initializePlayers() {
//        List<Player> players = Arrays.asList(
//                new Player("張小明", 95, "喜歡挑戰高難度遊戲，擅長解謎類型的遊戲。"),
//                new Player("陳小華", 88, "對多人合作遊戲情有獨鍾，是一位團隊合作的好夥伴。"),
//                new Player("李美玲", 92, "喜歡探險冒險型遊戲，尤其喜歡遊戲中的自由度。"),
//                new Player("王大偉", 78, "喜愛戰略遊戲，常常研究遊戲內的策略和戰術。"),
//                new Player("林小芳", 97, "對角色扮演遊戲熱衷，喜歡深入故事中體驗角色成長。"),
//                new Player("許阿力", 83, "偏好動作冒險遊戲，擅長應對敵人的快節奏戰鬥。"),
//                new Player("吳小琪", 89, "對休閒輕鬆型遊戲有興趣，享受放鬆的遊戲體驗。"),
//                new Player("蔡大勇", 94, "喜歡挑戰競技類遊戲，是一位高手在遊戲戰場上。"),
//                new Player("張芳瑜", 76, "喜歡夢幻風格的遊戲，喜歡遊走在奇幻世界中。")
//                
//        );
//
//        playerRepository.saveAll(players);
//    }
//
//    
//    private void assignPlayersToGames() {
//        List<GameRecord> gameRecords = gameRecordRepository.findAll();
//        List<Player> players = playerRepository.findAll();
//
//        for (GameRecord gameRecord : gameRecords) {
//            for (Player player : players) {
//                if (Math.random() > 0.5 && !player.getGameRecords().contains(gameRecord)) {
//                    player.getGameRecords().add(gameRecord);
//                }
//            }
//        }
//
//        playerRepository.saveAll(players); // 将保存移到外层循环之外
//    }
//}
