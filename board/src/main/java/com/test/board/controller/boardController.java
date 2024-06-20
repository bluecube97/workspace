package com.test.board.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.test.board.model.UserSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.test.board.service.BoardService;
import org.springframework.web.multipart.MultipartFile;

@RequestMapping("/board")
@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;

    @GetMapping("/unity")
    public String unity() {
        System.out.println("11111");
        return "game";
    }

    @GetMapping("/resource/Build/UnityPakage.framework.js.gz")
    @ResponseBody
    public ResponseEntity<ClassPathResource> getCompressedFile() throws IOException {
        System.out.println("22222");
        ClassPathResource gzFile = new ClassPathResource("Build/UnityPakage.framework.js.gz");
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Encoding", "gzip");
        headers.add("Content-Type", "application/javascript");
        headers.add("Cache-Control", "max-age=31536000, public");

        return new ResponseEntity<>(gzFile, headers, HttpStatus.OK);
    }

    @GetMapping("/list")
    public String getBoardList(@RequestParam(value = "keyword", required = false) String keyword,
                               @RequestParam(value = "page", required = false, defaultValue = "1") int page,
                               @RequestParam(value = "size", required = false, defaultValue = "10") int size,
                               @RequestParam(value = "bgno", required = false, defaultValue = "5") int bgno, Model model) {
        {
            // 조회 시 페이징 값 셋팅
            Map<String, Object> params = new HashMap<>();
            params.put("sw", keyword);
            int offset = (page - 1) * size;
            params.put("offset", offset);
            params.put("limit", size);
            params.put("bgno", bgno);

            List<Map<String, Object>> boardList = boardService.searchBoard(params);
            int totalRecords = boardService.countBoard(params);
            int totalPages = (int) Math.ceil((double) totalRecords / size);

            // 페이징 계산
            int startPage = ((page - 1) / 10) * 10 + 1;
            int endPage = Math.min(startPage + 9, totalPages);
            boolean hasPrev = startPage > 1;
            boolean hasNext = endPage < totalPages;

            model.addAttribute("boardList", boardList);
            model.addAttribute("keyword", keyword);
            model.addAttribute("currentPage", page);
            model.addAttribute("totalPages", totalPages);
            model.addAttribute("startPage", startPage);
            model.addAttribute("endPage", endPage);
            model.addAttribute("size", size);
            model.addAttribute("hasPrev", hasPrev);
            model.addAttribute("hasNext", hasNext);
            model.addAttribute("bgno", bgno);

            return "boardlist";
        }
    }

    @GetMapping("detail/{id}")
    public String detailView(@PathVariable("id") int id, Model model) {
        Map<String, Object> dv = boardService.detailView(id);
        model.addAttribute("post", dv);

        System.out.println("id : " + id);
        return "boardDetail";
    }

    @GetMapping("/write")
    public String registContent() {
        return "boardWrite";
    }

    public String registContent(@RequestParam("brdtitle") String brdtitle,
                                @RequestParam("brdmemo") String memo,
                                @RequestParam("file") List<MultipartFile> file,
                                @ModelAttribute("userSession") UserSession us,
                                Model model) {
        Map<String, Object> param = new HashMap<>();
        param.put("brdtitle", brdtitle);
        param.put("brdmemo", memo);
        param.put("userid", us.getUserId());
        param.put("file", file);

        boardService.registContent(param);

        return "redirect:/board/list";
    }
}
