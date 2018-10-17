package com.br.flashcard.services;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.flashcard.exceptions.RegisterNotFoundException;
import com.br.flashcard.models.Message;
import com.br.flashcard.repository.MessagesRepository;

@Service
public class MessageService {

	@Autowired
	private MessagesRepository msgRepository;

	public List<Message> getAll() {
		return this.msgRepository.findAll();
	}

	public Message save(Message msg) {
		msg.setCreatedAt(LocalDateTime.now());
		this.msgRepository.save(msg);
		return msg;
	}

	public Message update(Message msg, Long id) {
		Optional<Message> optMsg = this.msgRepository.findById(id);
		checkExists(optMsg);
		Message newMsg = optMsg.get();
		newMsg.setAuthor(msg.getAuthor());
		newMsg.setCreatedAt(msg.getCreatedAt());
		newMsg.setId(msg.getId());
		newMsg.setImage(msg.getImage());
		newMsg.setMessage(msg.getMessage());
		newMsg.setCardId(msg.getCardId());
		newMsg.setEdit(msg.isEdit());
		this.msgRepository.save(newMsg);
		return newMsg;
	}

	public Message delete(Long id) {
		Optional<Message> optMsg = this.msgRepository.findById(id);
		checkExists(optMsg);
		Message msg = optMsg.get();
		this.msgRepository.delete(msg);
		return msg;
	}

	private void checkExists(Optional<Message> msg) {
		if (!msg.isPresent()) {
			throw new RegisterNotFoundException("Message not exists");
		}
	}

}
