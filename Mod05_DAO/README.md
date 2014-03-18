Use packages `exercise1`, `exercise2` and so on when implementing the exercises. The solutions can be found from corresponding `solution` packages, for example solutions for `exercise1` can be found in package `solution1`.

Exercise 1
----------

This exercise contains a simple database application for managing blog posts. 

![UML structure of the blog application.](https://raw.githubusercontent.com/Codecenter/courses-spring-framework/master/Mod05_DAO/uml.png)

The main application class is `exercise1.BlogConsole`. It provides a simple console UI for the interface `blog.services.BlogService`. `blog.services.impl.BlogServiceImpl` implements the interface and uses `blog.dao.BlogPostDAO` for interacting the database.

The application uses an in-memory database by [HSQLDB](http://www.hsqldb.org). It is initialized by Spring using script `hsqldb-schema.sql` under `src/main/resources`. Any other database can also be used, but the schema script will probably not work without modifications.

From `blog.dao.jdbc.JDBCBlogPostDAO` you can find an implementation of the `BlogPostDAO` interface using raw JDBC. Your task in this exercise is to replace the implementation by using Spring JDBC.

1. Create a new class `exercise1.SpringJdbcBlogPostDAO`. Make a decision if you want to extend `JdbcDaoSupport` or initialize and use `JdbcTemplate` directly.
2. Implement the interface `blog.dao.BlogPostDAO`. Use the original implementation as a model, if necessary, but simplify it by using the functionality provided by `JdbcTemplate`.
3. Replace the existing `blogPostDAO` bean with the new implemention in `exercise1/applicationContext.xml` under `src/main/resources`.

Test the application by running the main application class `exercise1.BlogConsole`.

Exercise 2
----------

This exercise extends the previous one by replacing the (Spring) JDBC implementation with Java Persistence (JPA). The model class `blog.model.BlogPost` already contains the necessary annotations.

Your task is to create a new `BlogPostDAO` implementation `exercise2.JpaBlogPostDAO` using JPA. 

1. Create a new class `exercise2.JpaBlogPostDAO` and implement `blog.dao.BlogPostDAO`. If you're not too familiar with JPA, you can copy the implementation from `solution2.JpaBlogPostDAO` as this is a not a JPA exercise.
2. Replace the existing `blogPostDAO` bean with the new implemention in `exercise2/applicationContext.xml` under `src/main/resources`.
3. Setup JPA in the Spring configuration by using `org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean`.
  1. Use property `dataSource` to pass reference to the HSQLDB data source.
  2. Set property `jpaVendorAdapter` as bean of type `org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter`.
4. Setup transaction management using `org.springframework.orm.jpa.JpaTransactionManager`.
5. Bind transactions to any implementation of `blog.services.BlogService`.

Test the application by running the main application class `exercise2.BlogConsole`.

Exercise 3
----------

Add transaction management also to the (Spring) JDBC implementation done in exercise #1.
