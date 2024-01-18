package com.example.psi.controllar;

import com.example.psi.entity.GameRecord;
import com.example.psi.service.GameRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class GameRecordController {

    @Autowired
    private GameRecordService gameRecordService;

    @GetMapping("/createForm")
    public String createForm(Model model) {
        model.addAttribute("gameRecord", new GameRecord());
        return "createGameRecord";
    }

    @PostMapping("/saveRecord")
    public String saveRecord(@ModelAttribute GameRecord gameRecord) {
        gameRecordService.saveGameRecord(gameRecord);
        return "redirect:/createForm";
    }

    @GetMapping("/showRecords")
    public String showRecords(Model model) {
        List<GameRecord> gameRecords = gameRecordService.getAllGameRecords();
        model.addAttribute("gameRecords", gameRecords);
        return "showRecords";
    }
}
