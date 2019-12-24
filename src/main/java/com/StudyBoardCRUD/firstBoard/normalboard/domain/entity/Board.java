package com.StudyBoardCRUD.firstBoard.normalboard.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Getter
@Table(name = "board")
public class Board {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private User writer;

  @OneToOne(mappedBy = "boardType")
  @Column(nullable = false)
  private Long boardType;

  @Column(nullable = false)
  private String title;

  @Column(nullable = false)
  private String content;

  @Builder
  public Board(Long id, User writer, Long boardType, String title, String content) {
    this.id = id;
    this.writer = writer;
    this.boardType = boardType;
    this.title = title;
    this.content = content;
  }
}
