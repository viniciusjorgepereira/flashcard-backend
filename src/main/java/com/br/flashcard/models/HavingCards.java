package com.br.flashcard.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "having_cards")
public class HavingCards {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "user_email")
	@NotEmpty
	private String useremail;

	@Column(name = "card_id")
	@NotEmpty
	private Long cardid;

	public HavingCards() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserEmail() {
		return useremail;
	}

	public void setUserEmail(String userEmail) {
		this.useremail = userEmail;
	}

	public Long getCardId() {
		return cardid;
	}

	public void setCardId(Long cardId) {
		this.cardid = cardId;
	}

}
