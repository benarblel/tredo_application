package com.tredo.controller;

import com.tredo.domain.Board;
import com.tredo.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/boards")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping
    public List<Board> getAll() {
        return boardService.getAll();
    }

    @GetMapping("/{id}")
    public Board getById(@PathVariable Long id) {
        return boardService.getById(id);
    }

    @PostMapping
    public Board create(@RequestBody Board board) {
        return boardService.create(board);
    }

    @PutMapping("/{id}")
    public Board update(@PathVariable Long id, @RequestBody Board board) {
        return boardService.update(id, board);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        boardService.delete(id);
    }
}