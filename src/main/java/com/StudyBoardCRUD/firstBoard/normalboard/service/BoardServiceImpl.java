package com.StudyBoardCRUD.firstBoard.normalboard.service;

import com.StudyBoardCRUD.firstBoard.normalboard.domain.repository.BoardRepository;
import com.StudyBoardCRUD.firstBoard.normalboard.dto.BoardDto;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl implements BoardService {

  @Autowired
  private BoardRepository boardRepository;

  @Override
  public List<BoardDto> findBoardListByBoardType(long boardType) {
    return boardRepository.findBoardsByBoardType(boardType);
  }

  @Override
  public BoardDto findBoardById(long id) {
    return null;
  }
}
