/*
 * $Id$
 * Copyright (c) Codecenter Oy. All rights reserved.
 *
 * This software is the proprietary information of Codecenter Oy.
 * Use is subject to license terms.
 */
package blog.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import blog.dao.BlogPostDAO;
import blog.model.BlogPost;

public class JpaBlogPostDAO implements BlogPostDAO {
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<BlogPost> getBlogPosts() {
        return em.createQuery("from BlogPost order by created", BlogPost.class).getResultList();
    }

    @Override
    public BlogPost getBlogPost(int id) {
        return em.createQuery("from BlogPost where id = :id", BlogPost.class)
        		.setParameter("id", id).getSingleResult();
    }

    @Override
    public BlogPost storeBlogPost(BlogPost post) {
        return em.merge(post);
    }

    @Override
    public void deleteBlogPost(int id) {
        BlogPost post = em.getReference(BlogPost.class, id);
        em.remove(post);
    }
}
