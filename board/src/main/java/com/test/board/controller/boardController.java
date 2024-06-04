package com.test.board.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.test.board.service.BoardService;

@RequestMapping("/")
@Controller
public class boardController {

	@Autowired
	private BoardService boardsvc;
	
    @GetMapping("/boardList")
    public String boardListView(Model model) {
        List<Map<String, String>> blist = boardsvc.getBoardList();
        System.out.println(blist);
        model.addAttribute("blist", blist);
        return "boardList";
    }
	
}
