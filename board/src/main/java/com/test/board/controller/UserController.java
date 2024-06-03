package com.test.board.controller;

import com.test.board.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("/")
@Controller
public class UserController {

    @Autowired
    private UserService userSvc;

    @GetMapping("/login")
    public String loginView(){
        return "login";
    }

    @PostMapping("/login")
    @ResponseBody
    public Map<String, String> loginCheck(@RequestParam String pId, @RequestParam String pPass){
        Map<String, String> userInfo = new HashMap<>();
        userInfo.put("pId", pId);
        userInfo.put("pPass", pPass);

        boolean result = userSvc.loginCheck(userInfo);
        Map<String, String> response = new HashMap<>();

        if (result) {
            response.put("message", "로그인 성공");
        } else {
            response.put("message", "로그인 실패");
        }

        return response;
    }
}
