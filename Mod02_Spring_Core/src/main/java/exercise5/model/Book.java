package exercise5.model;

import java.io.Serializable;

public class Book implements Serializable {
	private Author author;
	private String title;
	private Integer yearPublished;
	private Integer latestEdition = 1;

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getYearPublished() {
		return yearPublished;
	}

	public void setYearPublished(Integer yearPublished) {
		this.yearPublished = yearPublished;
	}

	public Integer getLatestEdition() {
		return latestEdition;
	}

	public void setLatestEdition(Integer latestEdition) {
		this.latestEdition = latestEdition;
	}
}
