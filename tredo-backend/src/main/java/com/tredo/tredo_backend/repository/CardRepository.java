package com.tredo.tredo_backend.repository;

import com.tredo.tredo_backend.domain.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {
    List<Card> findByCardListId(Long cardListId);
}