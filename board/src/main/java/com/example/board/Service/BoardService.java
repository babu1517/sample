package com.example.board.Service;

import com.example.board.Entity.BoardEntity;
import org.springframework.data.domain.Page;

import java.util.ArrayList;

public interface BoardService {
    BoardEntity inputsave(BoardEntity boardEntity);


    ArrayList<BoardEntity> out();

    BoardEntity detail(long id);

    int updateReadcnt(long id);


    void updatesave(BoardEntity boardEntity);

    Page<BoardEntity> list(int page);
}
