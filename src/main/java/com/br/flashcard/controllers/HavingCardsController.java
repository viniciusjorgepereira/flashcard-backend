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

import com.br.flashcard.models.HavingCards;
import com.br.flashcard.services.HavingCardsService;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = "*")
public class HavingCardsController {

	@Autowired
	private HavingCardsService hcService;

	@RequestMapping(value = "/having", method = RequestMethod.GET)
	public List<HavingCards> getAll() {
		return this.hcService.getAll();
	}

	@RequestMapping(value = "/having", method = RequestMethod.POST)
	public HavingCards save(@RequestBody HavingCards hc) {
		return this.hcService.save(hc);
	}

	@RequestMapping(value = "/having/{id}", method = RequestMethod.GET)
	public HavingCards getById(@PathVariable("id") Long id) {
		return this.hcService.getById(id);
	}

	@RequestMapping(value = "/having/{id}", method = RequestMethod.PUT)
	public ResponseEntity<HavingCards> update(@PathVariable("id") Long id, @RequestBody HavingCards hc) {
		HavingCards update = this.hcService.update(hc, id);
		return new ResponseEntity<HavingCards>(update, HttpStatus.OK);
	}

	@RequestMapping(value = "/having", method = RequestMethod.DELETE)
	public ResponseEntity<HavingCards> delete(@PathVariable("id") Long id) {
		HavingCards hc = this.hcService.delete(id);
		return new ResponseEntity<HavingCards>(hc, HttpStatus.OK);
	}

}
