package com.example.psi.controllar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.example.psi.entity.User;
import com.example.psi.service.UserService;

import java.util.List;
import java.util.Optional;



@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @PostMapping("/login_backend")
    public String loginBackend(@RequestParam("username") String username,
                               @RequestParam("password") String password) {
        // 根據需要添加登入驗證邏輯
        // 這裡僅示範從數據庫中查找用戶
        User user = userService.findByUsername(username);

        if (user != null && user.getPassword().equals(password)) {
            // 登入成功
            return "redirect:/home"; // 跳轉到首頁或其他頁面
        } else {
            // 登入失敗
            return "redirect:/login?error"; // 跳轉到登入頁面並帶上錯誤提示
        }
    }

    // 可以添加其他控制器方法，處理第三方登入等

}
