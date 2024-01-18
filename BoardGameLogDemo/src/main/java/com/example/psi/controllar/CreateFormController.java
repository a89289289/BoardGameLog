package com.example.psi.controllar;

import com.example.psi.entity.GameRecord;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CreateFormController {

    @GetMapping("/createForm")
    public String createForm(Model model) {
        model.addAttribute("gameRecord", new GameRecord());
        return "createGameRecord";
    }
}
