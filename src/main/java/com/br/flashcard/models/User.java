package com.br.flashcard.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "users")
public class User {

	@Column(name = "username")
	@NotNull(message = "Username can't be null")
	@NotEmpty(message = "Username can't be empty")
	private String username;

	@Column(name = "image")
	private String image;

	@Id
	@Column(name = "email")
	@NotNull(message = "Email can't be null")
	@NotEmpty(message = "Email can't be empty")
	private String email;

	public User() {
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
