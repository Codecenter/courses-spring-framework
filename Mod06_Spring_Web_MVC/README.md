Use packages `exercise1`, `exercise2` and so on when implementing the exercises. The solutions can be found from corresponding `solution` packages, for example solutions for `exercise1` can be found in package `solution1`.

Exercise 1
----------

In this exercise you will implement a REST API for the blog application from the DAO exercise.

The REST API should offer the following services:

* `GET /blog/` List all blog posts.
* `POST /blog/` Add a new blog post.
* `GET /blog/<id>` Get the specified blog post.
* `PUT /blog/<id>` Update the specified blog post.
* `DELETE /blog/<id>` Delete the specified blog post.

If the specified blog post cannot be found, `404 Not Found` should be returned.

Start by implementing the `BlogController`:

1. Add a new class `exercise1.BlogController`.
2. Annotate the class with `@RestController`. This implies `@ResponseBody` and it does not need to be used on the methods.
3. Optionally you can use the `@RequestMapping` annotation at the class level to specify global options such as path prefix.
4. Add attribute of type `blog.services.BlogService` and annotate it with `@Autowired`.
5. Add method `listAll()` to return all `BlogPost`s.
 * You can return the `List<BlogPost>` directly, but if you want to support XML you'll need to create a wrapper class for the list.
 * Use `@RequestMapping` to specify a path, if necessary, and restrict only to `GET` methods.
6. Add method `addNew(BlogPost)` to add a new posting.
 * Annotate the parameter with `@RequestBody` to be able to post the data in, for example, JSON.
 * Use `@RequestMapping` to specify a path, if necessary, and restrict only to `POST` methods.
 * Use `BlogService.storeBlogPost(BlogPost)` to store the post to the database.
 * It's probably a good idea to ensure that the `BlogPost` has no `id` to ensure a new post is created.
7. Add method `getById(int)` to return a single `BlogPost`.
 * Annotate the parameter with `@PathVariable` to read the value from the URL.
 * You can return `BlogPost` directly. There's no need to use `@ResponseBody` if you have used the `@RestController` annotation.
 * Use `@RequestMapping` to specify a path, if necessary, and restrict only to `GET` methods.
8. Add method `update(int, BlogPost)` to update the specified post.
 * Annotate the `int` parameter with `@PathVariable` to read the value from the URL.
 * Annotate the `BlogPost` parameter with `@RequestBody` to be able to post the data in, for example, JSON.
 * Use `@RequestMapping` to specify a path, if necessary, and restrict only to `PUT` methods.
 * Use `BlogService.storeBlogPost(BlogPost)` to store the changes in the database.
 * It's probably a good idea to ensure that the `BlogPost.id` matches the `int` parameter.
9. Add method `deleteById(int)` to delete the specified post. 
 * Annotate the `int` parameter with `@PathVariable` to read the value from the URL.
 * The method does not have to return any value.
 * Use `@RequestMapping` to specify a path, if necessary, and restrict only to `DELETE` methods.
10. Add method `notFound(HttpServletResponse)` to handle exceptions related to non-existing posts.
 * Add annotation `@ExceptionHandler({ NoResultException.class, EntityNotFoundException.class })` to catch the necessary exceptions.
 * Use the `HttpServletResponse` to return `404 Not Found`. 
 
Next, configure the `BlogController` in `rest-exercise1.xml` found in `src/main/webapp/WEB-INF`:

1. Enable annotation scanning using `<context:component-scan base-package="exercise1" />`.
 * This definition will cause Spring to discover class `exercise1.BlogController` with annotation `@RestController`.
2. Enable MVC default settings using `<mvc:annotation-driven />`. 
 * You can read about the defaults in [the Spring reference manual](http://docs.spring.io/spring/docs/current/spring-framework-reference/html/mvc.html#mvc-config-enable).
 
Finally, see how Spring has been configured in the `web.xml`. The global `WebApplicationContext` specified using `<context-param />` contains all the business logic and data access related configuration while the `DispatcherServlet` has its own configuration focusing on the REST API. Also take a note of the `<url-pattern />` for the `DispatcherServlet`. You will need the value when testing the application.

You can start Apache Tomcat 7.0 directly from the Maven project by using `mvn tomcat7:run` on the command-line in the project directory. After Tomcat has started you can access the application under (http://localhost:8080/). 

Under `src/main/java` you can find a class `exercise1.RestClient` implementing a simple client for the REST API. You can use it to test your implementation. Make modifications as necessary.

To use the solution of this exercise, modify `DispatcherServlet`'s `<init-param />` value to point to `/WEB-INF/rest-solution1.xml`.

Exercise 2
----------

You can find class `exercise2.BlogConsole` under `src/main/java`. It is the same class that was used in the DAO exercises.

In this exercise your task is to re-implement the `blog.services.BlogService` interface so that it will access the REST API. No modifications to the `BlogConsole` should be necessary.

The `BlogConsole` uses configuration file `exercise2/applicationContext.xml` found under `src/main/resources`. Use the file to specify your new `blogService` bean.