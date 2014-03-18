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
import blog.model.BlogPost;
import blog.services.BlogService;

public class BlogServiceImpl implements BlogService {
    private BlogPostDAO dao;

    public void setBlogPostDAO(BlogPostDAO dao) {
        this.dao = dao;
    }

    @Override
    public List<BlogPost> getBlogPosts() {
        return dao.getBlogPosts();
    }
    
    @Override
    public BlogPost getBlogPost(int id) {
        return dao.getBlogPost(id);
    }

    @Override
	public BlogPost storeBlogPost(BlogPost post) {
    	Integer id = post.getId();
    	if (id == null) {
    		post.setCreated(new Date());
    	}
    	else {
    		BlogPost newPost = post;
    		post = getBlogPost(id);
    		post.setTitle(newPost.getTitle());
    		post.setMessage(newPost.getMessage());
    	}
		return dao.storeBlogPost(post);
	}

	@Override
    public void deleteBlogPost(int id) {
        dao.deleteBlogPost(id);
    }
}
