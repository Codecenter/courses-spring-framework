/*
 * $Id$
 * Copyright (c) Codecenter Oy. All rights reserved.
 *
 * This software is the proprietary information of Codecenter Oy.
 * Use is subject to license terms.
 */
package exercise1;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

import blog.model.BlogPost;

import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import solution1.BlogPostList;

public class RestClient {
    public static void main(String[] args) {
        final String URL_PREFIX = "http://localhost:8080/rest/blog";

        RestTemplate rest = new RestTemplate();

        // Add a new post
        System.out.println("Adding a new post:");

        BlogPost newPost = new BlogPost();
        newPost.setTitle("Hello REST!");
        newPost.setMessage("This is a post added using the REST interface.");

        BlogPost addedPost =
            rest.postForObject(URL_PREFIX + "/", newPost, BlogPost.class);
        System.out.println("SUCCESS!");
        printBlogPost(addedPost);

        // List blog posts
        System.out.println("\nListing all blog posts:");

        // You can either use a wrapper class or an array:
        // BlogPostList list =
        // rest.getForObject(URL_PREFIX + "/", BlogPostList.class);
        BlogPost[] list = rest.getForObject(URL_PREFIX + "/", BlogPost[].class);
        printBlogPosts(Arrays.asList(list));

        // Load a non-existing post
        System.out.println("\nLoading a non-existing post:");

        try {
            BlogPost notFound =
                rest.getForObject(URL_PREFIX + "/{id}", BlogPost.class, 9999);
            printBlogPost(notFound);
        }
        catch (HttpClientErrorException e) {
            HttpStatus code = e.getStatusCode();
            System.out.println(
                "HttpClientErrorException was thrown with StatusCode of " + code
                    + " which means " + e.getStatusText());
            e.printStackTrace();
            System.out.flush();
            System.err.flush();
        }

        // Delete a post with id 1
        System.out.println("\nDeleting a post with id 1:");
        rest.delete(URL_PREFIX + "/{id}", 1);
        System.out.println("SUCCESS!");

        // Delete a non-existing post
        System.out.println("\nDeleting a non-existing post:");
        rest.delete(URL_PREFIX + "/{id}", 9999);
        System.out.println("SUCCESS!");
    }

    protected static void printBlogPosts(BlogPostList list) {
        printBlogPosts(list.getBlogPost());
    }

    protected static void printBlogPost(BlogPost post) {
        printBlogPosts(Arrays.asList(post));
    }

    protected static void printBlogPosts(List<BlogPost> list) {
        System.out.println(
            "========================================================");
        if (list.isEmpty()) {
            System.out.println("The blog is empty.");
        }
        else {
            final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

            boolean first = true;
            for (BlogPost post : list) {
                if (!first) {
                    System.out.println(
                        "--------------------------------------------------------");
                }
                else {
                    first = false;
                }
                System.out.println("#" + post.getId() + " on "
                        + dateFormat.format(post.getCreated()) + ": "
                        + post.getTitle());
                System.out.println(post.getMessage());
            }
        }
        System.out.println(
            "========================================================");
    }
}
