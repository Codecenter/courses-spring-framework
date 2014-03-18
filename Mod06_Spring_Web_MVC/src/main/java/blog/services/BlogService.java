/*
 * $Id$
 * Copyright (c) Codecenter Oy. All rights reserved.
 *
 * This software is the proprietary information of Codecenter Oy.
 * Use is subject to license terms.
 */
package blog.services;

import java.util.List;

import blog.model.BlogPost;

public interface BlogService {
    List<BlogPost> getBlogPosts();

    BlogPost getBlogPost(int id);

    BlogPost storeBlogPost(BlogPost post);

    void deleteBlogPost(int id);

/* Service interfaces often contain other business logic as well:
    void registerBlogWatcher(String emailAddress);
    void stopWatchingBlog(String emailAddress);
*/
}
