package com.StudyBoardCRUD.firstBoard.normalboard.service;

import com.StudyBoardCRUD.firstBoard.normalboard.dto.BoardDto;
import java.util.List;
import org.springframework.stereotype.Component;

public interface BoardService {

  List<BoardDto> findBoardListByBoardType(long boardType);

  BoardDto findBoardById(long id);

}
