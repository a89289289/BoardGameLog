package com.example.psi.controllar;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CustomErrorController implements ErrorController {

    @GetMapping("/error")
    public String handleError() {
        // Provide your custom error handling logic or return a specific error page
        return "error";  // Assuming you have an "error.html" template
    }

    public String getErrorPath() {
        return "/error";
    }
}
