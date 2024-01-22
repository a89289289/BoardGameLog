package com.example.psi.controllar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.psi.entity.GameRecord;
import com.example.psi.service.GameService;

@Controller
@RequestMapping("/gameRecords")
public class GameController {

    @Autowired
    private GameService gameService;

    @GetMapping("/createForm")
    public String createForm(Model model) {
    	model.addAttribute("gameRecord", new GameRecord());
        return "createGameRecord";
    }

    @PostMapping("/saveRecord")
    public String saveRecord(@ModelAttribute GameRecord gameRecord) {
        gameService.saveGameRecord(gameRecord);
        return "redirect:/gameRecords/showRecords";
    }

    @GetMapping("/showRecords")
    public String showRecords(Model model) {
        Iterable<GameRecord> gameRecords = gameService.getAllGameRecords();
        model.addAttribute("gameRecords", gameRecords);
        return "showRecords";
    }
}