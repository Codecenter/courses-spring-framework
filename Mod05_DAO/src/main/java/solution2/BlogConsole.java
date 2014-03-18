/*
 * $Id$
 * Copyright (c) Codecenter Oy. All rights reserved.
 *
 * This software is the proprietary information of Codecenter Oy.
 * Use is subject to license terms.
 */
package solution2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import blog.model.BlogPost;
import blog.services.BlogService;

public class BlogConsole {
    protected static BlogService createBlogService() {
    	// Use ApplicationContext to enable container-managed
    	// transactions.
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "solution2/applicationContext.xml");
        return context.getBean("blogService", BlogService.class);
    }

    public static void main(String[] args) throws IOException {
        BlogService blog = createBlogService();

        System.out.println("Welcome to the blog console!");

        BufferedReader in = new BufferedReader(new InputStreamReader(
                    System.in));
        do {
            System.out.println(
                "Please enter command: list, post, delete, exit");
            System.out.print("> ");

            try {
                String line = in.readLine();
                if (line == null) {
                    break;
                }
                else {
                    String command = line.trim();
                    if (command.equalsIgnoreCase("exit")) {
                        System.out.println("Bye!");
                        return;
                    }
                    else if (command.equalsIgnoreCase("list")) {
                        String beginDateStr = readLine(in, "Begin date?");
                        if ("".equals(beginDateStr.trim())) {
                            printBlogPosts(blog.getBlogPosts());
                        }
                        else {
                            String endDateStr = readLine(in, "End date?");
                            if ("".equals(endDateStr.trim())) {
                                printBlogPosts(blog.getBlogPosts());
                            }
                            else {
                                DateFormat dateFormat = DateFormat
                                        .getDateInstance();
                                Date beginDate = dateFormat.parse(beginDateStr);
                                Date endDate = dateFormat.parse(endDateStr);
                                printBlogPosts(blog.getBlogPostsByDate(
                                        beginDate, endDate));
                            }
                        }
                    }
                    else if (command.equalsIgnoreCase("post")) {
                        String title = readLine(in, "Title?");
                        String message = readLine(in, "Message?");
                        blog.addBlogPost(title, message);
                    }
                    else if (command.equalsIgnoreCase("delete")) {
                        String value = readLine(in, "Id?");
                        int id = Integer.parseInt(value);
                        if (!blog.deleteBlogPost(id)) {
                            System.out.println("Post not found");
                        }
                    }
                }
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        while (true);
    }

    protected static String readLine(BufferedReader in, String prompt)
            throws IOException {
        System.out.print(prompt);
        System.out.print(' ');
        return in.readLine();
    }

    protected static void printBlogPosts(List<BlogPost> list) {
        if (list.isEmpty()) {
            System.out.println("The blog is empty.");
        }
        else {
            DateFormat dateFormat = DateFormat.getDateTimeInstance();
            for (BlogPost post : list) {
                System.out.println(
                    "========================================================");
                System.out.println("#" + post.getId() + " on "
                        + dateFormat.format(post.getCreated()) + ": "
                        + post.getTitle());
                System.out.println(post.getMessage());
                System.out.println(
                    "========================================================");
            }
        }
    }
}
