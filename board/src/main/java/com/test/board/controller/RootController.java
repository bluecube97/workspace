package com.test.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RootController {
	
	@RequestMapping("/")
	public String redirectBoard() {
		return "redirect:/board/list";
	}
}
