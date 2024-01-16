package com.example.psi.controllar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.psi.entity.GameRecord;
import com.example.psi.repository.GameRecordRepository;

@Controller
@RequestMapping("/gameRecords")
public class GameRecordController {

    @Autowired
    private GameRecordRepository gameRecordRepository;

    @GetMapping("/createForm")
    public String createForm(Model model) {
        model.addAttribute("gameRecord", new GameRecord());
        return "createGameRecord";
    }

    @PostMapping("/saveRecord")
    public String saveRecord(@ModelAttribute GameRecord gameRecord) {
        gameRecordRepository.save(gameRecord);
        return "redirect:/gameRecords/createForm";
    }
}
