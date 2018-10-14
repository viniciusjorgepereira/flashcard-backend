package com.br.flashcard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.flashcard.models.Message;

@Repository
public interface MessagesRepository extends JpaRepository<Message, Long> {

}
