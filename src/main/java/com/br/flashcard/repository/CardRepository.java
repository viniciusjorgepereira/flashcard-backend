package com.br.flashcard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.flashcard.models.Card;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {

}
