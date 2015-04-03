/*
 * $Id$
 * Copyright (c) Codecenter Oy. All rights reserved.
 *
 * This software is the proprietary information of Codecenter Oy.
 * Use is subject to license terms.
 */
package solution1;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.persistence.NoResultException;
import javax.servlet.http.HttpServletResponse;

import blog.model.BlogPost;

import blog.services.BlogService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private BlogService blogService;

    /**
     * If we're only working with JSON, we can return <code>
     * List&lt;BlogPost&gt;</code>, but if we want to be able to return XML
     * we'll need a wrapper like <code>BlogPostList</code>. Change the return
     * type accordingly.
     *
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public List<BlogPost> listAll() {
        // return new BlogPostList(blogService.getBlogPosts());
        return blogService.getBlogPosts();
    }

    @RequestMapping(method = RequestMethod.POST)
    public BlogPost addNew(@RequestBody BlogPost post) {
        post.setId(null); // Ensure new post is created
        return blogService.storeBlogPost(post);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public BlogPost getById(@PathVariable("id") int id) {
        return blogService.getBlogPost(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public BlogPost update(@PathVariable("id") int id,
                           @RequestBody BlogPost post) {
        post.setId(id); // Ensure existing post is updated
        return blogService.storeBlogPost(post);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteById(@PathVariable("id") int id) {
        blogService.deleteBlogPost(id);
    }

    @ExceptionHandler(
        { NoResultException.class, EntityNotFoundException.class })
    public void notFound(HttpServletResponse response) throws IOException {
        response.sendError(HttpServletResponse.SC_NOT_FOUND);
    }
}
