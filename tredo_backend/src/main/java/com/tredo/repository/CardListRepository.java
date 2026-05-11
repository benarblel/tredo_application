package com.tredo.repository;

import com.tredo.domain.CardList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardListRepository extends JpaRepository<CardList, Long> {
    List<CardList> findByBoardId(Long boardId);
}