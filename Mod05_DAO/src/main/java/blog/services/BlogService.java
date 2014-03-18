/*
 * $Id$
 * Copyright (c) Codecenter Oy. All rights reserved.
 *
 * This software is the proprietary information of Codecenter Oy.
 * Use is subject to license terms.
 */
package blog.services;

import java.util.Date;
import java.util.List;

import blog.dao.DAOException;
import blog.model.BlogPost;

//import org.springframework.transaction.annotation.Transactional;

//@Transactional
public interface BlogService {
    // @Transactional(readOnly = true)
    List<BlogPost> getBlogPosts() throws DAOException;

    // @Transactional(readOnly = true)
    List<BlogPost> getBlogPostsByDate(Date beginDate, Date endDate)
            throws DAOException;

    void addBlogPost(String title, String message) throws DAOException;

    boolean deleteBlogPost(int id) throws DAOException;

/* Service interfaces often contain other business logic as well:
    void registerBlogWatcher(String emailAddress);
    void stopWatchingBlog(String emailAddress);
*/
}
