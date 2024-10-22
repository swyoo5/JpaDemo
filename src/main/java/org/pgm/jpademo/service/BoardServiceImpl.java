package org.pgm.jpademo.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.pgm.jpademo.domain.Board;
import org.pgm.jpademo.dto.BoardDTO;
import org.pgm.jpademo.dto.PageRequestDTO;
import org.pgm.jpademo.dto.PageResponseDTO;
import org.pgm.jpademo.repository.BoardRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
@RequiredArgsConstructor // final
public class BoardServiceImpl implements BoardService {
    private final BoardRepository boardRepository; // @RequiredArgsConstructor
    private final ModelMapper modelMapper;

    @Override
    public PageResponseDTO<BoardDTO> getList(PageRequestDTO pageRequestDTO) {
        log.info("getList");

//        Pageable pageable = pageRequestDTO.getPageable("bno");
//        Page<Board> result=null;
//        if (pageRequestDTO.getKeyword()==null || pageRequestDTO.getKeyword().equals("")) {
//            result = boardRepository.findAll(pageable);
//        } else {
//            result = boardRepository.searchAll(pageRequestDTO.getKeyword(), pageable);
//        }
        String[] types=pageRequestDTO.getTypes();
        String keyword=pageRequestDTO.getKeyword();
        Pageable pageable=pageRequestDTO.getPageable("bno");
        Page<Board> result=boardRepository.searchAll(types,keyword,pageable);
        List<BoardDTO> dtoList =result.getContent().stream()
                        .map(board -> modelMapper.map(board, BoardDTO.class))
                        .collect(Collectors.toUnmodifiableList());
        return PageResponseDTO.<BoardDTO>withAll()
                .pageRequestDTO(pageRequestDTO)
                .dtoList(dtoList)
                .total((int)result.getTotalElements())
                .build();
    }

    @Override
    public Board getBoard(Long bno) {
        log.info("Get board by id: " + bno);
        Board board = boardRepository.findById(bno).get();
        board.updateVisitcount();
        boardRepository.save(board);
        return board;
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
