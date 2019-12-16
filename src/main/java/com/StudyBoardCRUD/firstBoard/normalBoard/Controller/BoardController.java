package com.StudyBoardCRUD.firstBoard.normalBoard.Controller;

import com.StudyBoardCRUD.firstBoard.normalBoard.DTO.Board;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BoardController {
  @GetMapping("/board/list")
  public Board getBoardList() {
    Board board = new Board(1L, "Hello World!", "first API");

    return board;
  }
}
