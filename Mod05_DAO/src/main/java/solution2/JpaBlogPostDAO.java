/*
 * $Id$
 * Copyright (c) Codecenter Oy. All rights reserved.
 *
 * This software is the proprietary information of Codecenter Oy.
 * Use is subject to license terms.
 */
package solution2;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;

import blog.dao.BlogPostDAO;
import blog.dao.DAOException;

import blog.model.BlogPost;

public class JpaBlogPostDAO implements BlogPostDAO {
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<BlogPost> getBlogPosts() throws DAOException {
        return em.createQuery("from BlogPost order by created", BlogPost.class)
                .getResultList();
    }

    @Override
    public List<BlogPost> getBlogPostsByDate(Date beginDate, Date endDate)
            throws DAOException {
        TypedQuery<BlogPost> query =
            em.createQuery("from BlogPost "
                    + "where created >= :beginDate and created <= :endDate",
                BlogPost.class);
        query.setParameter("beginDate", beginDate, TemporalType.DATE);
        query.setParameter("endDate", endDate, TemporalType.DATE);
        return query.getResultList();
    }

    @Override
    public void addBlogPost(BlogPost newPost) throws DAOException {
        em.persist(newPost);
    }

    @Override
    public boolean deleteBlogPost(int id) throws DAOException {
        BlogPost post = em.find(BlogPost.class, id);
        if (post == null) {
            return false;
        }
        else {
            em.remove(post);
            return true;
        }
    }
}
