package com.tredo.tredo_backend.service;

import com.tredo.tredo_backend.domain.CardList;
import com.tredo.tredo_backend.domain.Board;
import com.tredo.tredo_backend.repository.CardListRepository;
import com.tredo.tredo_backend.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CardListService {

    private final CardListRepository cardListRepository;
    private final BoardRepository boardRepository;

    public List<CardList> getByBoard(Long boardId) {
        return cardListRepository.findByBoardId(boardId);
    }

    public CardList create(Long boardId, CardList cardList) {
        Board board = boardRepository.findById(boardId)
                .orElseThrow(() -> new RuntimeException("Board not found with id: " + boardId));
        cardList.setBoard(board);
        return cardListRepository.save(cardList);
    }

    public CardList update(Long id, CardList data) {
        CardList cardList = cardListRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("List not found with id: " + id));
        cardList.setName(data.getName());
        cardList.setPosition(data.getPosition());
        return cardListRepository.save(cardList);
    }

    public void delete(Long id) {
        cardListRepository.deleteById(id);
    }
}