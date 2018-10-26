package com.br.flashcard.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.br.flashcard.models.Message;

@Repository
public interface MessagesRepository extends JpaRepository<Message, Long> {

	@Query("select m from Message m where m.cardId=?1")
	List<Message> getMessagesByCardId(Long id);
	
}
