package org.pgm.jpademo.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.pgm.jpademo.domain.Board;
import org.pgm.jpademo.repository.BoardRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
@RequiredArgsConstructor // final
public class BoardServiceImpl implements BoardService {
    private final BoardRepository boardRepository; // @RequiredArgsConstructor

    @Override
    public List<Board> getList() {
        log.info("getList");
        return boardRepository.findAll();
    }

    @Override
    public Board getBoard(Long bno) {
        log.info("Get board by id: " + bno);
        return boardRepository.findById(bno).get();
    }

    @Override
    public void saveBoard(Board board) {
        log.info("save board" + board);
        boardRepository.save(board);
    }

    @Override
    public void updateBoard(Board board) {
        log.info("update board" + board);
        // update는 바로 저장하면 일부 데이터 null로 들어간다.
        Board oldBoard = boardRepository.findById(board.getBno()).get();
        oldBoard.setTitle(board.getTitle());
        oldBoard.setContent(board.getContent());
        oldBoard.setWriter(board.getWriter());
        boardRepository.save(oldBoard);
    }

    @Override
    public void deleteBoard(Long bno) {
        log.info("Delete Board" + bno);
        boardRepository.deleteById(bno);
    }
}
