package com.example.psi.controllar;

import com.example.psi.entity.GameRecord;
import com.example.psi.service.GameRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SaveRecordController {

    @Autowired
    private GameRecordService gameRecordService;

    @PostMapping("/saveRecord")
    public String saveRecord(@ModelAttribute GameRecord gameRecord) {
        gameRecordService.saveGameRecord(gameRecord);
        return "redirect:/createForm";
    }
}
