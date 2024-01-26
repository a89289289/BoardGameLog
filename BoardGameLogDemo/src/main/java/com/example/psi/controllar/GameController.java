package com.example.psi.controllar;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.psi.entity.GameRecord;
import com.example.psi.entity.Player;
import com.example.psi.repository.GameRecordRepository;
import com.example.psi.service.GameRecordService;
import com.example.psi.service.GameService;

@Controller
@RequestMapping("/gameRecords")
public class GameController {

    @Autowired
    private GameService gameService;
    @Autowired
    private GameRecordRepository gameRecordRepository;

    @GetMapping("/createForm")
    public String createForm(Model model) {
    	model.addAttribute("gameRecord", new GameRecord());
        return "createGameRecord";
    }

    @PostMapping("/saveRecord")
    public String saveRecord(@ModelAttribute GameRecord gameRecord) {
    	System.out.println(gameRecord.toString());
    	
        gameService.saveGameRecord(gameRecord);
        
        return "redirect:/gameRecords/showRecords";
    }

    @GetMapping("/showRecords")
    public String showRecords(Model model) {
        Iterable<GameRecord> gameRecords = gameService.getAllGameRecords();
        model.addAttribute("gameRecords", gameRecords);
        return "showRecords";
    }
    
    @GetMapping("/home")
    public String home(Model model) {
    	List<GameRecord> gameRecords = gameRecordRepository.findAll();
        model.addAttribute("gameRecords", gameRecords);
        return "home";
    }
    
        
    @GetMapping("/login")
    public String login(Model model) {
    	
        return "login";
    }
    
//    @GetMapping("/getDataForCharts")
//    @ResponseBody
//    public Map<String, Object> getDataForCharts() {
//        Map<String, Object> data = new HashMap<>();
//        
//        // 获取游戏遊玩次數数据，格式应为 List<Object[]>，每个 Object[] 包含游戏名和遊玩次數
//        List<Object[]> gamePlayData = gameService.getGamePlayData();
//        
//        // 获取游戏日期統計数据，格式应为 List<Object[]>，每个 Object[] 包含日期和遊戲次數
//        List<Object[]> gameDateData = gameService.getGameDateData();
//        
//        data.put("gamePlayData", gamePlayData);
//        data.put("gameDateData", gameDateData);
//        
//        return data;
//    }
    
    @Autowired
    private GameRecordService gameRecordService;

    @GetMapping("/gameStats")
    public String gameStats(Model model) {
        Map<String, Long> gamePlayTimes = gameRecordService.countGamePlayTimes();
        model.addAttribute("gamePlayTimes", gamePlayTimes);
        System.out.println(gamePlayTimes);
        return "gameStats"; // 这里返回Thymeleaf模板的名称
    }
    
//  @GetMapping("/gameStats")
//  @ResponseBody
//  public Map<String, Long> gameStats() {
//      Map<String, Long> gamePlayTimes = gameRecordService.countGamePlayTimes();
//      System.out.println("in!");
//      return gamePlayTimes; // 这里返回Thymeleaf模板的名称
//  }
}