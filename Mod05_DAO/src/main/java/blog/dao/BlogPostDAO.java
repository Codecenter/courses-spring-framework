/*
 * $Id$
 * Copyright (c) Codecenter Oy. All rights reserved.
 *
 * This software is the proprietary information of Codecenter Oy.
 * Use is subject to license terms.
 */
package blog.dao;

import java.util.Date;
import java.util.List;

import blog.model.BlogPost;

public interface BlogPostDAO {
    /**
     * Returns a <code>List</code> containing all <code>BlogPost</code>s in the
     * database.
     *
     * @return a <code>List</code> containing <code>BlogPost</code>s
     * @throws DAOException is thrown in case of a database error.
     */
    List<BlogPost> getBlogPosts() throws DAOException;

    /**
     * Returns a <code>List</code> containing <code>BlogPost</code>s whose
     * <code>timestamp</code> is within the given range.
     *
     * @param beginDate DOCUMENT ME!
     * @param endDate DOCUMENT ME!
     * @return a <code>List</code> containing <code>BlogPost</code>s
     * @throws DAOException is thrown in case of a database error.
     */
    List<BlogPost> getBlogPostsByDate(Date beginDate, Date endDate)
            throws DAOException;

    /**
     * Adds the <code>BlogPost</code> to the database.
     *
     * @param newPost the new <code>BlogPost</code>
     * @throws DAOException is thrown in case of a database error.
     */
    void addBlogPost(BlogPost newPost) throws DAOException;

    /**
     * Deletes the specified <code>BlogPost</code> from the database.
     *
     * @param id an <code>int</code> identifying the <code>BlogPost</code>
     * @return a <code>boolean</code> whether or not the operation was
     *         successful
     * @throws DAOException is thrown in case of a database error.
     */
    boolean deleteBlogPost(int id) throws DAOException;
}
