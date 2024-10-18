package org.pgm.jpademo.controller;

import lombok.extern.log4j.Log4j2;
import org.pgm.jpademo.domain.Board;
import org.pgm.jpademo.domain.Item;
import org.pgm.jpademo.service.BoardService;
import org.pgm.jpademo.service.BoardServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Log4j2
@RequestMapping("/board")
public class BoardController {
    @Autowired
    private BoardService boardService;
    @GetMapping("/list")
    public void list(Model model) {
        log.info("controller list");
        model.addAttribute("boardList", boardService.getList());
    }

    @GetMapping("/register")
    public void registerGet() {
        log.info("controller registerGet");
    }

    @PostMapping("/register")
    public String registerPost(Board board) {
        log.info("controller registerPost");
        boardService.saveBoard(board);
        return "redirect:/board/list";
    }

    @GetMapping("/read")
    public String read(@RequestParam("bno") Long bno, Model model) {
        Board board = boardService.getBoard(bno);
        model.addAttribute("dto", board);
        return "board/read";
    }
}