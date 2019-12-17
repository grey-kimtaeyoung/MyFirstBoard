package com.StudyBoardCRUD.firstBoard.normalBoard.service;

import com.StudyBoardCRUD.firstBoard.normalBoard.dto.Board;

public interface BoardService {

  Board findBoardListByBoardType(String boardType);

}
