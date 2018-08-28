package com.br.flashcard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.flashcard.models.HavingCards;

@Repository
public interface HavingCardsRepository extends JpaRepository<HavingCards, Long> {
	
}
