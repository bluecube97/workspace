package com.test.spring_test_240605.user.controller;

import com.test.spring_test_240605.user.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RequestMapping("/")
@Controller
public class userController {

    @Autowired
    private userService usersvc;

    @GetMapping("/")
    private String home() {
        return "login";
    }

    @GetMapping("/login")
    private String loginView() {
        return "login";
    }

    @PostMapping("/login")
    @ResponseBody
    private Map<String, String> loginCheck(@RequestParam String pid, @RequestParam String ppass, HttpServletRequest req) {
        Map<String, String> userIdPw = new HashMap<>();
        userIdPw.put("pid", pid);
        userIdPw.put("ppass", ppass);

        boolean result = usersvc.loginCheck(userIdPw);
        Map<String, String> responses = new HashMap<>();

        if (result) {
            responses.put("message", "로그인 성공");
            responses.put("isSuccess", "true");

            System.out.println("message : " + responses.get("message"));

            HttpSession session = req.getSession();
            Map<String, Object> userInfo = usersvc.getUserInfo(pid);
            session.setAttribute("userInfo", userInfo);
            System.out.println("세션 넘기기 성공");
        } else {
            responses.put("message", "로그인 실패");
            responses.put("isSuccess", "false");
        }

        return responses;
    }
}
