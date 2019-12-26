package com.StudyBoardCRUD.firstBoard.normalboard.controller;

import com.StudyBoardCRUD.firstBoard.normalboard.dto.BoardDto;
import com.StudyBoardCRUD.firstBoard.normalboard.service.BoardService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/board")
public class Boardcontroller {

  private final BoardService boardService;

  @Autowired
  public Boardcontroller(BoardService boardService) {
    this.boardService = boardService;
  }

  @GetMapping("/{boardType}")
  public ResponseEntity<List<BoardDto>> getBoardList(
      @RequestParam(value = "boardType",
          defaultValue = "normal",
          required = false) long boardType) {

    List<BoardDto> boardDtoList = boardService.findBoardListByBoardType(boardType);

    return new ResponseEntity<>(boardDtoList, HttpStatus.OK);
  }

  @GetMapping("/{boardType}/{id}")
  public ResponseEntity<BoardDto> getBoard(
      @RequestParam(value = "boardType",
          defaultValue = "normal",
          required = false) long boardType,
      @RequestParam(value = "id",
      defaultValue = "normal",
      required = false) long id) {

    BoardDto boardDto = boardService.findBoardById(id);

    return new ResponseEntity<BoardDto>(boardDto, HttpStatus.OK);
  }

  @PostMapping("")
  public ResponseEntity<List<BoardDto>> postBoard(
      @RequestParam(value = "boardType",
          defaultValue = "normal",
          required = false) long boardType) {

    List<BoardDto> boardDtoList = boardService.findBoardListByBoardType(boardType);

    return new ResponseEntity<>(boardDtoList, HttpStatus.OK);
  }

  @DeleteMapping("/{boardType}/{id}")
  public ResponseEntity<List<BoardDto>> delBoard(
      @RequestParam(value = "boardType",
          defaultValue = "normal",
          required = false) long boardType) {

    List<BoardDto> boardDtoList = boardService.findBoardListByBoardType(boardType);

    return new ResponseEntity<>(boardDtoList, HttpStatus.OK);
  }
}
