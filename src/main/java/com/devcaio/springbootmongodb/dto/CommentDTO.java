package com.devcaio.springbootmongodb.dto;

import java.io.Serializable;
import java.time.Instant;

public class CommentDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private AuthorDTO author;
	private String text;
	private Instant date;
	
	public CommentDTO() {
	}

	public CommentDTO(AuthorDTO author, String text, Instant date) {
		this.author = author;
		this.text = text;
		this.date = date;
	}

	public AuthorDTO getAuthor() {
		return author;
	}

	public void setAuthor(AuthorDTO author) {
		this.author = author;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Instant getDate() {
		return date;
	}

	public void setDate(Instant date) {
		this.date = date;
	}

}
