/*
 * $Id$
 * Copyright (c) Codecenter Oy. All rights reserved.
 *
 * This software is the proprietary information of Codecenter Oy.
 * Use is subject to license terms.
 */
package exercise5;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import exercise5.dao.AuthorDAO;
import exercise5.dao.BookDAO;
import exercise5.services.LibraryService;
import exercise5.services.impl.LibraryServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class TestClient {
	@Resource
	private ApplicationContext context;
	public static final String LIBRARY_SERVICE_NAME = "libraryService";
	public static final String AUTHOR_DAO_NAME = "authorDAO";
	public static final String BOOK_DAO_NAME = "bookDAO";

	@Test
	public void verifyLibraryService() {
		verifyBean(LibraryService.class, LIBRARY_SERVICE_NAME, true);

		LibraryService ls = context.getBean(LIBRARY_SERVICE_NAME,
				LibraryService.class);
		assertEquals("Bean '" + LIBRARY_SERVICE_NAME
				+ "' not the expected implementation",
				LibraryServiceImpl.class, ls.getClass());
		LibraryServiceImpl lsImpl = (LibraryServiceImpl) ls;

		assertNotNull("Property 'authorDAO' not set in 'libraryService'",
				lsImpl.getAuthorDAO());
		assertNotNull("Property 'bookDAO' not set in 'libraryService'",
				lsImpl.getBookDAO());

		assertNotNull("Property 'maxLoanPeriodInDays' not set in 'libraryService'",
				lsImpl.getMaxLoanPeriodInDays());
		assertTrue("Property 'maxLoanPeriodInDays' not set to a positive integer in 'libraryService'",
				lsImpl.getMaxLoanPeriodInDays() > 0);
	}

	@Test
	public void verifyAuthorDAO() {
		verifyBean(AuthorDAO.class, AUTHOR_DAO_NAME, false);
	}

	@Test
	public void verifyBookDAO() {
		verifyBean(BookDAO.class, BOOK_DAO_NAME, false);
	}

	protected void verifyBean(Class expectedType, String expectedName,
			boolean required) {
		Map<String, Object> beans = context.getBeansOfType(expectedType);
		if (beans.size() > 1) {
			fail("Found multiple beans of type " + expectedType.getName()
					+ ", why?");
		} else if (!beans.isEmpty()) {
			Object bean = beans.values().iterator().next();
			assertNotNull("The bean " + bean.getClass().getName()
					+ " should be named after the interface",
					beans.get(expectedName));
		} else if (required) {
			fail("Cannot find required bean of type " + expectedType.getName());
		}
	}
}
