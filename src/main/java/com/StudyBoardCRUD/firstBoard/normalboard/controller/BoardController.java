package com.StudyBoardCRUD.firstBoard.normalboard.controller;

import com.StudyBoardCRUD.firstBoard.normalboard.domain.entity.Board;
import com.StudyBoardCRUD.firstBoard.normalboard.domain.entity.User;
import com.StudyBoardCRUD.firstBoard.normalboard.dto.BoardDto;
import com.StudyBoardCRUD.firstBoard.normalboard.service.BoardService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/board")
public class BoardController {

  private final BoardService boardService;

  @Autowired
  public BoardController(BoardService boardService) {
    this.boardService = boardService;
  }

  @GetMapping("/{boardType}")
  public ResponseEntity<List<BoardDto>> getBoardList(
      @PathVariable(value = "boardType",
          required = false) long boardType) {

    User writer = User.builder()
        .id(1L)
        .email("test@gmail.com")
        .name("kimtaeyoung")
        .nickName("daniel")
        .userId("daniel_grey")
        .build();

    Board board = Board.builder()
        .id(1L)
        .boardType(1L)
        .content("content")
        .title("title")
        .writer(writer)
        .build();

    BoardDto boardDto = BoardDto.builder()
        .boardType(board.getBoardType())
        .content(board.getContent())
        .id(board.getId())
        .title(board.getTitle())
        .writer(board.getWriter())
        .build();

    List<BoardDto> boardDtoList = new ArrayList<BoardDto>();

    boardDtoList.add(boardDto);

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
