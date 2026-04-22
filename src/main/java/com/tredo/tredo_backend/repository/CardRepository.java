package com.tredo.tredo_backend.repository;

import com.tredo.tredo_backend.domain.Card;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CardRepository extends JpaRepository<Card, Long> {
    List<Card> findByCardListId(Long cardListId);
}