/*
 * $Id$
 * Copyright (c) Codecenter Oy. All rights reserved.
 *
 * This software is the proprietary information of Codecenter Oy.
 * Use is subject to license terms.
 */
package blog.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.sql.DataSource;

import blog.dao.BlogPostDAO;
import blog.dao.DAOException;

import blog.model.BlogPost;

public class JdbcBlogPostDAO implements BlogPostDAO {
    private DataSource ds;

    public JdbcBlogPostDAO(DataSource ds) {
        this.ds = ds;
    }

    @Override
    public List<BlogPost> getBlogPosts() throws DAOException {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = ds.getConnection();
            stmt =
                conn.prepareStatement(
                    "select * from blog_posts order by created");
            return queryBlogPosts(stmt);
        }
        catch (SQLException e) {
            throw new DAOException(e);
        }
        finally {
            if (stmt != null) {
                try {
                    stmt.close();
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public List<BlogPost> getBlogPostsByDate(Date beginDate, Date endDate)
            throws DAOException {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = ds.getConnection();
            stmt =
                conn.prepareStatement("select * from blog_posts "
                        + "where created >= ? and created <= ? "
                        + "order by created");
            stmt.setDate(1, new java.sql.Date(beginDate.getTime()));
            stmt.setDate(2, new java.sql.Date(endDate.getTime()));

            return queryBlogPosts(stmt);
        }
        catch (SQLException e) {
            throw new DAOException(e);
        }
        finally {
            if (stmt != null) {
                try {
                    stmt.close();
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    protected List<BlogPost> queryBlogPosts(PreparedStatement stmt)
            throws SQLException {
        ResultSet rs = stmt.executeQuery();
        List<BlogPost> results = new LinkedList<BlogPost>();
        while (rs.next()) {
            BlogPost post = new BlogPost();
            post.setId(rs.getInt("id"));
            post.setCreated(rs.getDate("created"));
            post.setTitle(rs.getString("title"));
            post.setMessage(rs.getString("message"));
            results.add(post);
        }
        return results;
    }

    @Override
    public void addBlogPost(BlogPost newPost) throws DAOException {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = ds.getConnection();
            stmt =
                conn.prepareStatement(
                    "insert into blog_posts(created, title, message) "
                        + "values(?, ?, ?)");
            stmt.setDate(1, new java.sql.Date(newPost.getCreated().getTime()));
            stmt.setString(2, newPost.getTitle());
            stmt.setString(3, newPost.getMessage());
            stmt.executeUpdate();
        }
        catch (SQLException e) {
            throw new DAOException(e);
        }
        finally {
            if (stmt != null) {
                try {
                    stmt.close();
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public boolean deleteBlogPost(int id) throws DAOException {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = ds.getConnection();
            stmt = conn.prepareStatement("delete from blog_posts where id = ?");
            stmt.setInt(1, id);
            return stmt.executeUpdate() == 1;
        }
        catch (SQLException e) {
            throw new DAOException(e);
        }
        finally {
            if (stmt != null) {
                try {
                    stmt.close();
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
