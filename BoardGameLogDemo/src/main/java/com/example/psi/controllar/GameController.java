package com.example.psi.controllar;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	@Autowired
	private GameRecordService gameRecordService;

	// 首頁(遊戲數據)
	@GetMapping("/home")
	public String home(Model model) {
		List<GameRecord> gameRecords = gameRecordRepository.findAll();
		model.addAttribute("gameRecords", gameRecords);
		return "home";
	}

	// 新增遊戲紀錄
	@GetMapping("/createForm")
	public String createForm(Model model) {
		model.addAttribute("gameRecord", new GameRecord());
		return "createGameRecord";
	}

	// 儲存遊戲紀錄
	@PostMapping("/saveRecord")
	public String saveRecord(@ModelAttribute GameRecord gameRecord) {
		System.out.println(gameRecord.toString());

		gameService.saveGameRecord(gameRecord);

		return "redirect:/gameRecords/showRecords";
	}

	// 修改遊戲紀錄
	@GetMapping("/editRecord/{id}")
	public String editRecord(@PathVariable("id") Long id, Model model) {
		GameRecord gameRecord = gameRecordService.getGameRecordById(id);
		model.addAttribute("gameRecord", gameRecord);
		// 假設你想要檢索與此遊戲紀錄關聯的玩家
		model.addAttribute("players", gameRecord.getPlayers());
		return "createGameRecord-edit";
	}

	@PostMapping("/editRecord/{id}")
	public String updateRecord(@PathVariable("id") Long id, @ModelAttribute("gameRecord") GameRecord updatedGameRecord) {
	    // 透過ID找到現有的遊戲紀錄
	    GameRecord existingGameRecord = gameRecordRepository.findById(id)
	            .orElseThrow(() -> new IllegalArgumentException("無效的遊戲紀錄ID：" + id));

	    // 更新現有遊戲紀錄的內容
	    existingGameRecord.setGameName(updatedGameRecord.getGameName());
	    existingGameRecord.setGameDate(updatedGameRecord.getGameDate());
	    existingGameRecord.setPhoto(updatedGameRecord.getPhoto());

	    // 清空既有的玩家列表
	    existingGameRecord.getPlayers().clear();

	    // 將新的玩家列表加入現有遊戲紀錄
	    if (updatedGameRecord.getPlayers() != null) {
	        for (Player player : updatedGameRecord.getPlayers()) {
	            existingGameRecord.addPlayer(player);
	        }
	    }

	    // 保存更新後的遊戲紀錄
	    gameRecordRepository.save(existingGameRecord);

	    // 重定向到顯示遊戲紀錄的頁面
	    return "redirect:/gameRecords/showRecords";
	}

	// 刪除遊戲紀錄
	@GetMapping("/deleteRecord/{id}")
	public String deleteRecord(@PathVariable("id") Long id) {
		gameRecordService.deleteGameRecord(id);
		return "redirect:/gameRecords/showRecords";
	}

	// 顯示遊戲紀錄
	@GetMapping("/showRecords")
	public String showRecords(Model model) {
		Iterable<GameRecord> gameRecords = gameService.getAllGameRecords();
		model.addAttribute("gameRecords", gameRecords);
		return "showRecords";
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

	@GetMapping("/gameStats")
	public String gameStats(Model model) {
		Map<String, Long> gamePlayTimes = gameRecordService.countGamePlayTimes();
		model.addAttribute("gamePlayTimes", gamePlayTimes);
		System.out.println(gamePlayTimes);
		return "gameStats"; // 这里返回Thymeleaf模板的名称
	}
//    
//  @GetMapping("/gameStats")
//  @ResponseBody
//  public Map<String, Long> gameStats() {
//      Map<String, Long> gamePlayTimes = gameRecordService.countGamePlayTimes();
//      System.out.println("in!");
//      return gamePlayTimes; // 这里返回Thymeleaf模板的名称
//  }
}