package com.StudyBoardCRUD.firstBoard.normalBoard.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Board {
  private long id;
  private String title;
  private String content;
}
