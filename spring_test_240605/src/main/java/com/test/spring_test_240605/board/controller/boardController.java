package com.test.spring_test_240605.board.controller;

import com.test.spring_test_240605.board.service.boardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@RequestMapping("/board")
@Controller
public class boardController {

    @Autowired
    private boardService brdsvc;

    @GetMapping("/list")
    private ModelAndView getBoardList(ModelAndView model, HttpSession session){
        List<Map<String, String>> blist = brdsvc.getBoardList();
        model.addObject("blist", blist);
        model.addObject("userInfo", session);
        model.setViewName("boardList");

        return model;
    }

    @GetMapping("/detail")
    private ModelAndView getBoardDetail(ModelAndView model, HttpSession session, @RequestParam("brdno") int brdNo){
        Map<String, String> detail = brdsvc.getBoardDetail(brdNo);
        model.addObject("detail", detail);
        model.addObject("userInfo", session);
        model.setViewName("boardDetail");

        return model;
    }
}
