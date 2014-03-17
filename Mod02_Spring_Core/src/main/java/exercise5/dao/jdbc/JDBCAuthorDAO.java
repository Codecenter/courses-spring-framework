package exercise5.dao.jdbc;

import java.util.List;

import exercise5.dao.AuthorDAO;
import exercise5.model.Author;

public class JDBCAuthorDAO implements AuthorDAO {

	@Override
	public List<Author> getAuthors() {
		throw new UnsupportedOperationException("Not yet implemented");
	}

	@Override
	public Author storeAuthor(Author author) {
		throw new UnsupportedOperationException("Not yet implemented");
	}

	@Override
	public void deleteAuthor(Author author) {
		throw new UnsupportedOperationException("Not yet implemented");
	}

}
