package exercise5.services;

import java.util.List;

import exercise5.model.Author;
import exercise5.model.Book;

public interface LibraryService {
	List<Author> getAuthors();
	Author storeAuthor(Author author);
	void deleteAuthor(Author author);

	List<Book> getBooks();
	Book storeBook(Book book);
	void deleteBook(Book book);
	void borrowBook(Book book) throws LibraryException;
	void returnBook(Book book) throws LibraryException;
}
