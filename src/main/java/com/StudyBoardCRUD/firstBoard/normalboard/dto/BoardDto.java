package com.StudyBoardCRUD.firstBoard.normalboard.dto;

import com.StudyBoardCRUD.firstBoard.normalboard.domain.entity.Board;
import com.StudyBoardCRUD.firstBoard.normalboard.domain.entity.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@NoArgsConstructor
public class BoardDto {

  private long id;
  private String title;
  private User writer;
  private String content;
  private Long boardType;

  public Board toEntity() {
    return Board.builder()
        .id(id)
        .title(title)
        .writer(writer)
        .content(content)
        .boardType(boardType)
        .build();
  }

  @Builder
  public BoardDto(long id, String title,
      User writer, String content, Long boardType) {
    this.id = id;
    this.title = title;
    this.writer = writer;
    this.content = content;
    this.boardType = boardType;
  }
}
