package com.StudyBoardCRUD.firstBoard.normalBoard.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BoardController {
  @GetMapping("/board/list")
  public Board getBoardList() {

  }
}
