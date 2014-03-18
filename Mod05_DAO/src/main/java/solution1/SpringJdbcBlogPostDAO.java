/*
 * $Id$
 * Copyright (c) Codecenter Oy. All rights reserved.
 *
 * This software is the proprietary information of Codecenter Oy.
 * Use is subject to license terms.
 */
package solution1;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import blog.dao.BlogPostDAO;
import blog.dao.DAOException;
import blog.model.BlogPost;

public class SpringJdbcBlogPostDAO extends JdbcDaoSupport
        implements BlogPostDAO {
    @Override
    public List<BlogPost> getBlogPosts() throws DAOException {
        return getJdbcTemplate().query(
        		"select * from blog_posts order by created",
                new BlogPostRowMapper());
    }

    @Override
    public List<BlogPost> getBlogPostsByDate(Date beginDate, Date endDate)
            throws DAOException {
        Calendar cal = Calendar.getInstance();
        cal.setTime(endDate);
        cal.add(Calendar.DATE, 1);
        endDate = cal.getTime();
        return getJdbcTemplate().query(
                "select * from blog_posts "
                + "where created >= ? and created < ? "
                + "order by created",
                new Object[] { beginDate, endDate },
                new int[] { Types.DATE, Types.DATE },
                new BlogPostRowMapper());
    }

    @Override
    public void addBlogPost(BlogPost newPost) throws DAOException {
        getJdbcTemplate().update(
            "insert into blog_posts(created, title, message) values(?, ?, ?)",
            newPost.getCreated(), newPost.getTitle(), newPost.getMessage());

//      getJdbcTemplate().update(
//              "insert into blog_posts(created, title, message) values(?, ?, ?)",
//              new Object[] { newPost.getCreated(), newPost.getTitle(),
//                      newPost.getMessage() },
//              new int[] { Types.TIMESTAMP, Types.VARCHAR, Types.VARCHAR });
    }

    @Override
    public boolean deleteBlogPost(int id) throws DAOException {
        return getJdbcTemplate().update(
                "delete from blog_posts where id = ?", id) == 1;
    }
}

class BlogPostRowMapper implements RowMapper<BlogPost> {
    @Override
    public BlogPost mapRow(ResultSet rs, int rowNum) throws SQLException {
        BlogPost post = new BlogPost();
        post.setId(rs.getInt("id"));
        post.setCreated(rs.getTimestamp("created"));
        post.setTitle(rs.getString("title"));
        post.setMessage(rs.getString("message"));
        return post;
    }
}
