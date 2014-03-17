package solution5;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import exercise5.dao.AuthorDAO;
import exercise5.dao.BookDAO;
import exercise5.dao.jdbc.JDBCAuthorDAO;
import exercise5.dao.jdbc.JDBCBookDAO;
import exercise5.services.LibraryService;
import exercise5.services.impl.LibraryServiceImpl;

@Configuration
public class JavaConfig {
	@Bean
	public AuthorDAO authorDAO() {
		return new JDBCAuthorDAO();
	}
	
	@Bean
	public BookDAO bookDAO() {
		return new JDBCBookDAO();
	}
	
	@Bean
	public LibraryService libraryService(BookDAO bookDAO, AuthorDAO authorDAO) {
		LibraryServiceImpl ls = new LibraryServiceImpl(bookDAO);
		ls.setAuthorDAO(authorDAO);
		ls.setMaxLoanPeriodInDays(30);
		return ls;
	}
}
