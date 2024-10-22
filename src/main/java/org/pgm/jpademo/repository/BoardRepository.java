package org.pgm.jpademo.repository;

import org.pgm.jpademo.domain.Board;
import org.pgm.jpademo.repository.search.BoardSearch;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BoardRepository extends JpaRepository<Board, Long>, BoardSearch {
//    @Query("select b from Board b where b.title like concat('%', :keyword, '%') order by b.bno desc")
//    Page<Board> searchAll(String keyword, Pageable pageable);
//    Page<Board> findByTitle(String title, Pageable pageable);
}
