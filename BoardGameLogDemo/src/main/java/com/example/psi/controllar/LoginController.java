package com.example.psi.controllar;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class LoginController {

    @GetMapping("/login")
    public String getLoginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String login() {
        // Add custom login logic if needed
        return "redirect:/home"; // Redirect to home page after successful login
    }

    @GetMapping("/home")
    public String home() {
        // Add logic for the home page
        return "home";
    }

}
