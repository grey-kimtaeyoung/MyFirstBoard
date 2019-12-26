package com.StudyBoardCRUD.firstBoard.normalboard.service

import com.StudyBoardCRUD.firstBoard.normalboard.domain.entity.BoardType
import com.StudyBoardCRUD.firstBoard.normalboard.domain.repository.BoardRepository
import com.StudyBoardCRUD.firstBoard.normalboard.dto.BoardDto
import spock.lang.Specification

class BoardServiceImplTests extends Specification {
    def "FindBoardListByBoardType"() {
        setup:
        def boardType = new BoardType()
        boardType.id = 1
        boardType.typeName = "cloth"

        def mockBoardRepo = Mock(BoardRepository.class)
        def service = new BoardServiceImpl(mockBoardRepo)

        when:
        def boardList = service.findBoardListByBoardType(1)

        then:
        boardList instanceof List<BoardDto>
        boardList.get(0) == null
    }
}
