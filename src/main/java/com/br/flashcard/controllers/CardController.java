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

import com.br.flashcard.models.Card;
import com.br.flashcard.services.CardService;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = "*")
public class CardController {

	@Autowired
	private CardService cardService;

	@RequestMapping(value = "/card", method = RequestMethod.GET)
	public List<Card> getAllPublicCards() {
		return this.cardService.getAllPublicCards();
	}

	@RequestMapping(value = "/card", method = RequestMethod.POST)
	public Card save(@RequestBody Card card) {
		return this.cardService.save(card);
	}

	@RequestMapping(value = "/card/{id}", method = RequestMethod.GET)
	public Card getById(@PathVariable("id") Long id) {
		return this.cardService.getById(id);
	}

	@RequestMapping(value = "/card/user/{author}", method = RequestMethod.GET)
	public List<Card> getUserCards(@PathVariable("author") String author) {
		return this.cardService.getUserCards(author);
	}

	@RequestMapping(value = "/card/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Card> update(@PathVariable("id") Long id, @RequestBody Card card) {
		Card updateCard = this.cardService.update(card, id);
		return new ResponseEntity<Card>(updateCard, HttpStatus.OK);
	}

	@RequestMapping(value = "/card/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Card> delete(@PathVariable("id") Long id) {
		Card card = this.cardService.delete(id);
		return new ResponseEntity<Card>(card, HttpStatus.OK);
	}

}
