package com.StudyBoardCRUD.firstBoard.normalboard.controller;

import static org.hamcrest.core.StringContains.containsString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.StudyBoardCRUD.firstBoard.normalboard.domain.entity.User;
import com.StudyBoardCRUD.firstBoard.normalboard.dto.BoardDto;
import com.StudyBoardCRUD.firstBoard.normalboard.service.BoardService;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(BoardController.class)
public class BoardControllerTests {

  @Autowired
  private MockMvc mvc;

  @MockBean
  private BoardService boardService;

  @Test
  public void getBoardList() throws Exception {
    List<BoardDto> boardDtos = new ArrayList<>();

    User writer = User.builder()
        .id(1L)
        .email("test@gmail.com")
        .name("kimtaeyoung")
        .nickName("daniel")
        .userId("daniel_grey")
        .build();

    BoardDto boardDto = BoardDto.builder()
        .writer(writer)
        .title("title")
        .id(1L)
        .content("content")
        .boardType(1L)
        .build();

    boardDtos.add(boardDto);

    given(boardService.findBoardListByBoardType(1L)).willReturn(boardDtos);

    mvc.perform(get("/board/1"))
        .andExpect(status().isOk())
        .andExpect(content().string(containsString("\"id\":1")))
        .andExpect(content().string(containsString(
            "\"writer\":{\"id\":1,\"userId\":null,\"password\":null,\"name\":null,\"nickName\":null,\"email\":null,\"role\":null,\"createdAt\":null,\"lastLoggedIn\":null}")))
        .andExpect(content().string(containsString("\"boardType\":1")))
        .andExpect(content().string(containsString("\"title\":\"title\"")))
        .andExpect(content().string(containsString("\"content\":\"content\"")));
  }
}