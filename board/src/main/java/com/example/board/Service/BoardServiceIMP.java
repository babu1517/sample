package com.example.board.Service;

import com.example.board.Entity.BoardEntity;
import com.example.board.Reposiroty.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class BoardServiceIMP implements BoardService {
    @Autowired
    BoardRepository boardRepository;

    @Override
    public BoardEntity inputsave(BoardEntity boardEntity) {
        return boardRepository.save(boardEntity);
    }

    @Override
    public ArrayList<BoardEntity> out() {
        return (ArrayList<BoardEntity>) boardRepository.findAll();
    }

    @Override
    public BoardEntity detail(long id) {
        return boardRepository.findById(id).orElse(null);
    }

    @Override
    public int updateReadcnt(long id) {

        return boardRepository.updateReadcnt(id);
    }

    @Override
    public void updatesave(BoardEntity boardEntity) {
        boardRepository.save(boardEntity);
    }

    @Override
    public Page<BoardEntity> list(int page) {
        return boardRepository.findAll(PageRequest.of(page,5,Sort.by(Sort.Direction.ASC,"id")));
    }


}
