package com.StudyBoardCRUD.firstBoard.normalBoard.controller;

import com.StudyBoardCRUD.firstBoard.normalBoard.dto.Board;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/board")
public class BoardController {
  @GetMapping("/list")
  public Board getBoardList() {
    Board board = new Board(1L, "Hello World!", "first API", "normal");

    return board;
  }
}
