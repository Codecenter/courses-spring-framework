package exercise5.dao;

import java.util.List;

import exercise5.model.Book;

public interface BookDAO {
	List<Book> getBooks();
	Book storeBook(Book book);
	void deleteBook(Book book);
}
