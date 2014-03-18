/*
 * $Id$
 * Copyright (c) Codecenter Oy. All rights reserved.
 *
 * This software is the proprietary information of Codecenter Oy.
 * Use is subject to license terms.
 */
package blog.services.impl;

import java.util.Date;
import java.util.List;

import blog.dao.BlogPostDAO;
import blog.dao.DAOException;
import blog.model.BlogPost;
import blog.services.BlogService;

public class BlogServiceImpl implements BlogService {
    private BlogPostDAO dao;

    public void setBlogPostDAO(BlogPostDAO dao) {
        this.dao = dao;
    }

    @Override
    public List<BlogPost> getBlogPosts() throws DAOException {
        return dao.getBlogPosts();
    }

    @Override
    public List<BlogPost> getBlogPostsByDate(Date beginDate, Date endDate)
            throws DAOException {
        return dao.getBlogPostsByDate(beginDate, endDate);
    }

    @Override
    public void addBlogPost(String title, String message) throws DAOException {
        BlogPost newPost = new BlogPost();
        newPost.setCreated(new Date());
        newPost.setTitle(title);
        newPost.setMessage(message);
        dao.addBlogPost(newPost);
    }

    @Override
    public boolean deleteBlogPost(int id) throws DAOException {
        return dao.deleteBlogPost(id);
    }
}
