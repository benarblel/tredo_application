package com.tredo.tredo_backend.service;

import com.tredo.tredo_backend.domain.Board;
import com.tredo.tredo_backend.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    public List<Board> getAll() {
        return boardRepository.findAll();
    }

    public Board getById(Long id) {
        return boardRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Board not found with id: " + id));
    }

    public Board create(Board board) {
        return boardRepository.save(board);
    }

    public Board update(Long id, Board data) {
        Board board = getById(id);
        board.setName(data.getName());
        return boardRepository.save(board);
    }

    public void delete(Long id) {
        boardRepository.deleteById(id);
    }
}