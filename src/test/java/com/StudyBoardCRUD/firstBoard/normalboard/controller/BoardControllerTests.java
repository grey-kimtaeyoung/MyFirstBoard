package com.StudyBoardCRUD.firstBoard.normalboard.controller;

import static org.hamcrest.core.StringContains.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(BoardController.class)
public class BoardControllerTests {

  @Autowired
  private MockMvc mvc;

  @Test
  public void getBoardList() throws Exception {
    mvc.perform(get("/board/1"))
        .andExpect(status().isOk())
        .andExpect(content().string(containsString("\"id\":1")))
        .andExpect(content().string(containsString("\"writer\":1")))
        .andExpect(content().string(containsString("\"boardType\":1")))
        .andExpect(content().string(containsString("\"title\":\"title\"")))
        .andExpect(content().string(containsString("\"content\":\"content\"")));
  }
}