package com.test.board.controller;

import com.test.board.model.UserSession;
import com.test.board.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

@Controller
@SessionAttributes("userSession")
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @ModelAttribute("userSession")
    public UserSession createSession() {
        return new UserSession();
    }

    @GetMapping("/login")
    public String showLoginPage() {
        return "login"; // login.jsp
    }

    @PostMapping("/login")
    @ResponseBody
    public Map<String, Object> handleLogin(@RequestBody Map<String, Object> params, @ModelAttribute("userSession") UserSession us) {
        Map<String, Object> response = new HashMap<>();
        Map<String, Object> result = userService.loginCheck(params);

        if (result != null) {
            us.setUserId((String) result.get("USERID"));
            us.setUserNm((String) result.get("USERNM"));
            us.setRole((String) result.get("USERROLE"));
            us.setDeptNo(String.valueOf(result.get("DEPTNO")));
            response.put("redirect", "/board/list");
        } else {
            response.put("message", "ID, PASSWORD 를 확인하세요");
        }
        return response;
    }

    @GetMapping("/logout")
    public String logOut(HttpSession session, SessionStatus status) {
        status.setComplete();
        session.invalidate();
        return "redirect:/board/list";
    }
}