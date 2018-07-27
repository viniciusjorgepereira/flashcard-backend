package com.br.flashcard.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "cards")
public class Card {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "discipline")
	@NotNull(message = "Discipline can't be null")
	@NotEmpty(message = "Discipline can't be empty")
	private String discipline;

	@Column(name = "question")
	@NotNull(message = "Question can't be null")
	@NotEmpty(message = "Question can't be empty")
	private String question;

	@Column(name = "answer")
	@NotNull(message = "Answer can't be null")
	@NotEmpty(message = "Answer can't be empty")
	private String answer;

	@Column(name = "privacy")
	private boolean privacy;

	public Card() {
	}

	public String getDiscipline() {
		return discipline;
	}

	public void setDiscipline(String discipline) {
		this.discipline = discipline;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public boolean isPrivacy() {
		return privacy;
	}

	public void setPrivacy(boolean privacy) {
		this.privacy = privacy;
	}

}
