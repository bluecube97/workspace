package com.test.board.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.board.service.UserService;

@RequestMapping("/")
@Controller
public class userController {

	@Autowired
	private UserService usersvc;
	
	@GetMapping("/login")
	private String loginView() {
		return "login";
	}
	
	@PostMapping("/login")
	@ResponseBody
	private Map<String, String> loginCheck(@RequestParam String pid, @RequestParam String ppass){
		Map<String, String> userInfo = new HashMap<String, String>();
		System.out.println(pid + ppass);
		userInfo.put("pid", pid);
		userInfo.put("ppass", ppass);
		
		boolean result = usersvc.loginCheck(userInfo);
		System.out.println("result" + result);
		Map<String, String> responses = new HashMap<>();
		
		if (result) {
			responses.put("message", "로그인 성공인데스");
		}else {
			responses.put("message", "로그인 실패인데스");
		}
		return responses;
	}
}
