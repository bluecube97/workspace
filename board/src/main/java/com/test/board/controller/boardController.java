package com.test.board.controller;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.test.board.service.BoardService;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/")
@Controller
public class boardController {

	@Autowired
	private BoardService boardsvc;
	
    @GetMapping("/boardList")
    public ModelAndView boardListView(ModelAndView model) {
        List<Map<String, String>> blist = boardsvc.getBoardList();
        System.out.println(blist);
        model.addObject("blist", blist);
        model.setViewName("boardList");
        return model;
    }

    @GetMapping("/boardDetail")
    public ModelAndView boardDetailView(ModelAndView model, @RequestParam("brdno") int boardNo) {
        Map<String, Object> detail = boardsvc.getBoardDetail(boardNo);
        model.addObject("detail", detail);
        model.setViewName("boardDetail");
        return model;
    }
	
}
