/*
 * $Id$
 * Copyright (c) Codecenter Oy. All rights reserved.
 *
 * This software is the proprietary information of Codecenter Oy.
 * Use is subject to license terms.
 */
package blog.dao;

import java.util.List;

import blog.model.BlogPost;

public interface BlogPostDAO {
    /**
     * Returns a <code>List</code> containing all <code>BlogPost</code>s in the
     * database.
     *
     * @return a <code>List</code> containing <code>BlogPost</code>s
     */
    List<BlogPost> getBlogPosts();

    /**
     * Returns the specified <code>BlogPost</code> from the database.
     *
     * @param id an <code>int</code> identifying the <code>BlogPost</code>
     * @return a <code>BlogPost</code> containing the post
     */
    BlogPost getBlogPost(int id);

    /**
     * Stores the <code>BlogPost</code> in the database.
     *
     * @param post a <code>BlogPost</code>
     * @return a <code>BlogPost</code> that has been stored in the database.
     */
    BlogPost storeBlogPost(BlogPost post);

    /**
     * Deletes the specified <code>BlogPost</code> from the database.
     *
     * @param id an <code>int</code> identifying the <code>BlogPost</code>
     */
    void deleteBlogPost(int id);
}
