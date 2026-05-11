package com.tredo.controller;

import com.tredo.domain.CardList;
import com.tredo.service.CardListService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/boards/{boardId}/lists")
@RequiredArgsConstructor
public class CardListController {

    private final CardListService cardListService;

    @GetMapping
    public List<CardList> getAll(@PathVariable Long boardId) {
        return cardListService.getByBoard(boardId);
    }

    @PostMapping
    public CardList create(@PathVariable Long boardId, @RequestBody CardList cardList) {
        return cardListService.create(boardId, cardList);
    }

    @PutMapping("/{id}")
    public CardList update(@PathVariable Long boardId, @PathVariable Long id, @RequestBody CardList cardList) {
        return cardListService.update(id, cardList);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long boardId, @PathVariable Long id) {
        cardListService.delete(id);
    }
}