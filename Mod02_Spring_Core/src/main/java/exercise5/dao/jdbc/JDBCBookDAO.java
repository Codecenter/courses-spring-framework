package exercise5.dao.jdbc;

import java.util.List;

import exercise5.dao.BookDAO;
import exercise5.model.Book;

public class JDBCBookDAO implements BookDAO {

	@Override
	public List<Book> getBooks() {
		throw new UnsupportedOperationException("Not yet implemented");
	}

	@Override
	public Book storeBook(Book book) {
		throw new UnsupportedOperationException("Not yet implemented");
	}

	@Override
	public void deleteBook(Book book) {
		throw new UnsupportedOperationException("Not yet implemented");
	}

}
