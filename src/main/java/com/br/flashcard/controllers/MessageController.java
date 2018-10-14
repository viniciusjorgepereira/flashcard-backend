package com.br.flashcard.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.br.flashcard.models.Message;
import com.br.flashcard.services.MessageService;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = "*")
public class MessageController {

	@Autowired
	private MessageService msgService;

	@RequestMapping(value = "/msg", method = RequestMethod.GET)
	public List<Message> getAll() {
		return this.msgService.getAll();
	}

	@RequestMapping(value = "/msg", method = RequestMethod.POST)
	public Message save(@RequestBody Message msg) {
		return this.msgService.save(msg);
	}

	@RequestMapping(value = "/msg/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Message> update(@PathVariable("id") Long id, @RequestBody Message msg) {
		Message updateMessage = this.msgService.update(msg, id);
		return new ResponseEntity<Message>(updateMessage, HttpStatus.OK);
	}

	@RequestMapping(value = "/msg/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Message> delete(@PathVariable("id") Long id) {
		Message msg = this.msgService.delete(id);
		return new ResponseEntity<Message>(msg, HttpStatus.OK);
	}

}
