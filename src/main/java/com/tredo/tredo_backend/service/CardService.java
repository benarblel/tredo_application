package com.tredo.tredo_backend.service;

import com.tredo.tredo_backend.domain.Card;
import com.tredo.tredo_backend.domain.CardList;
import com.tredo.tredo_backend.repository.CardRepository;
import com.tredo.tredo_backend.repository.CardListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CardService {

    private final CardRepository cardRepository;
    private final CardListRepository cardListRepository;

    public List<Card> getByList(Long listId) {
        return cardRepository.findByCardListId(listId);
    }

    public Card create(Long listId, Card card) {
        CardList cardList = cardListRepository.findById(listId)
                .orElseThrow(() -> new RuntimeException("List not found with id: " + listId));
        card.setCardList(cardList);
        return cardRepository.save(card);
    }

    public Card update(Long id, Card data) {
        Card card = cardRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Card not found with id: " + id));
        card.setTitle(data.getTitle());
        card.setDescription(data.getDescription());
        card.setPosition(data.getPosition());
        return cardRepository.save(card);
    }

    public void delete(Long id) {
        cardRepository.deleteById(id);
    }
}