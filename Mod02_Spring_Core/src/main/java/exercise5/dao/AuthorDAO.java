package exercise5.dao;

import java.util.List;

import exercise5.model.Author;

public interface AuthorDAO {
	List<Author> getAuthors();
	Author storeAuthor(Author author);
	void deleteAuthor(Author author);
}
