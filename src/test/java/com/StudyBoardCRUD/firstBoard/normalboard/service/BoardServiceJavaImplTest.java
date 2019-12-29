package com.StudyBoardCRUD.firstBoard.normalboard.service;

import static org.hamcrest.MatcherAssert.assertThat;

import static org.hamcrest.core.Is.is;
import com.StudyBoardCRUD.firstBoard.normalboard.domain.repository.BoardRepository;
import com.StudyBoardCRUD.firstBoard.normalboard.dto.BoardDto;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class BoardServiceJavaImplTest {

  private BoardRepository boardRepository;
  private BoardServiceImpl boardService;

  @Before
  public void setUp() {
    boardService = new BoardServiceImpl(boardRepository);
  }

  @Test
  public void findBoardListByBoardType() {
    List<BoardDto> boardDtos = boardRepository.findBoardsByBoardType(1L);

    BoardDto boardDto = boardDtos.get(0);

    assertThat(boardDto.getId(), is(1L));
  }

  @Test
  public void findBoardById() {
  }
}