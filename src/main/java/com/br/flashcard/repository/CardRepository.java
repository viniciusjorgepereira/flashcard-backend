package com.br.flashcard.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.br.flashcard.models.Card;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {

	@Query("select c from Card c where c.privacy=true")
	List<Card> getAllPublicCards();

	@Query("select c from Card c where c.author=?1")
	List<Card> getUserCards(String author);

}
