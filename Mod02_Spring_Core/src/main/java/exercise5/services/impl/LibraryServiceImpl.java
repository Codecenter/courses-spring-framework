package exercise5.services.impl;

import java.util.List;

import exercise5.dao.AuthorDAO;
import exercise5.dao.BookDAO;
import exercise5.model.Author;
import exercise5.model.Book;
import exercise5.services.LibraryException;
import exercise5.services.LibraryService;

public class LibraryServiceImpl implements LibraryService {
	private AuthorDAO authorDAO;
	private BookDAO bookDAO;
	private Integer maxLoanPeriodInDays;

	public LibraryServiceImpl(BookDAO bookDAO) {
		this.bookDAO = bookDAO;
	}
	
	public AuthorDAO getAuthorDAO() {
		return authorDAO;
	}

	public void setAuthorDAO(AuthorDAO authorDAO) {
		this.authorDAO = authorDAO;
	}

	public BookDAO getBookDAO() {
		return bookDAO;
	}

	public void setBookDAO(BookDAO bookDAO) {
		this.bookDAO = bookDAO;
	}

	public Integer getMaxLoanPeriodInDays() {
		return maxLoanPeriodInDays;
	}

	public void setMaxLoanPeriodInDays(Integer maxLoanPeriodInDays) {
		this.maxLoanPeriodInDays = maxLoanPeriodInDays;
	}

	@Override
	public List<Author> getAuthors() {
		return authorDAO.getAuthors();
	}

	@Override
	public Author storeAuthor(Author author) {
		return authorDAO.storeAuthor(author);
	}

	@Override
	public void deleteAuthor(Author author) {
		authorDAO.deleteAuthor(author);
	}

	@Override
	public List<Book> getBooks() {
		return bookDAO.getBooks();
	}

	@Override
	public Book storeBook(Book book) {
		return bookDAO.storeBook(book);
	}

	@Override
	public void deleteBook(Book book) {
		bookDAO.deleteBook(book);
	}

	@Override
	public void borrowBook(Book book) throws LibraryException {
		throw new UnsupportedOperationException("Not yet implemented");
	}

	@Override
	public void returnBook(Book book) throws LibraryException {
		throw new UnsupportedOperationException("Not yet implemented");
	}
}
