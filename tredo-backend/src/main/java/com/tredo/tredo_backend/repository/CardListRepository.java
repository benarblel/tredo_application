package com.tredo.tredo_backend.repository;

import com.tredo.tredo_backend.domain.CardList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardListRepository extends JpaRepository<CardList, Long> {
    List<CardList> findByBoardId(Long boardId);
}