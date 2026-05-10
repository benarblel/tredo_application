package com.tredo.tredo_backend.controller;

import com.tredo.tredo_backend.domain.Card;
import com.tredo.tredo_backend.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/lists/{listId}/cards")
@RequiredArgsConstructor
public class CardController {

    private final CardService cardService;

    @GetMapping
    public List<Card> getAll(@PathVariable Long listId) {
        return cardService.getByList(listId);
    }

    @PostMapping
    public Card create(@PathVariable Long listId, @RequestBody Card card) {
        return cardService.create(listId, card);
    }

    @PutMapping("/{id}")
    public Card update(@PathVariable Long listId, @PathVariable Long id, @RequestBody Card card) {
        return cardService.update(id, card);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long listId, @PathVariable Long id) {
        cardService.delete(id);
    }
}