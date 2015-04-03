Exercises for Spring Core
=========================

Use packages `exercise1`, `exercise2` and so on when implementing the exercises.
The solutions can be found in the corresponding `solution` packages, for example 
solutions for `exercise1` can be found in package `solution1`.

Exercise 1
----------

In this exercise you'll code the classic Hello World using Spring Framework's 
basic features.

Create an interface `exercise1.HelloService` and store it under `src/main/java`. 
Define a single method `void sayHello()`.

Next, implement the interface in class `exercise1.HelloServiceImpl`. The method
`sayHello()` should print something like "Hello World!" using 
`System.out.println` so that you can verify it being executed.

Create a file named `helloContext.xml` in the project root folder (where the 
`pom.xml` is located). You can copy XML schema definitions from the example 
below:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
                           http://www.springframework.org/schema/beans/spring-beans.xsd">
    <!-- Your configuration goes here. -->
</beans>
```

Define a single Spring bean named "myHelloService" using the previously created 
class `exercise1.HelloServiceImpl`.

Finally, add a new application class `exercise1.HelloClient`:

1. Add method `public static void main(String[] args)` so that the application 
   can be started.
2. In the main method construct an `XmlBeanFactory` instance by calling the 
   constructor with a `FileSystemResource` object with path `helloContext.xml`. 
   The path is relative to the folder where the application is started (ie. 
   the project's root folder).
3. Using the `XmlBeanFactory` obtain the bean named "myHelloService" using 
   `getBean`. Use [the javadoc](http://docs.spring.io/spring/docs/current/javadoc-api/index.html?org/springframework/beans/factory/BeanFactory.html) 
   of the `BeanFactory` interface to find a suitable method, if necessary.
4. If necessary, perform type cast to the `HelloService` interface and call the 
   `sayHello` method.
5. Make sure that `HelloClient` does not reference the actual implementation 
   `HelloServiceImpl`, but is aware only of the interface `HelloService`.

Run the application and verify that it works as intended.

Exercise 2
----------

Copy all types from the previous exercise to package `exercise2`. Make sure all 
copied classes now refer to the new package!

Copy Spring configuration file `helloContext.xml` to class path resource folder 
`src/main/resources`. Place the file to package `exercise2`. Add missing 
directories, if necessary.

Edit class `exercise2.HelloClient` to use `ClassPathResource` instead of 
`FileSystemResource` in the previous exercise. Pass the constructor value 
`exercise2/helloContext.xml`.

Run the application and verify that it works as intended.

Exercise 3
----------

Copy all types from the previous exercise to package `exercise3`. Make sure all 
copied classes now refer to the new package!

Edit class `exercise3.HelloServiceImpl` implementation to use 
`ClassPathXmlApplicationContext` instead of `XmlBeanFactory`.

Run the application and verify that it works as intended.

Exercise 4
----------

Copy all types from the previous exercise to package `exercise4`. Make sure all 
copied classes now refer to the new package!

Edit class `exercise4.HelloServiceImpl` implementation so that the message text 
can be specified using attribute `messageText`. Decide how you want the 
attribute value to be set (a set method or constructor or both). Then use the 
Spring configuration to set the attribute value to "Hola!". 

Run the application and verify that it works as intended.

Exercise 5
----------

The project template for the exercise contains the following classes and 
interfaces:

* `exercise5.dao.AuthorDAO`
* `exercise5.dao.BookDAO`
* `exercise5.dao.jdbc.JDBCAuthorDAO`
* `exercise5.dao.jdbc.JDBCBookDAO`
* `exercise5.model.Author`
* `exercise5.model.Book`
* `exercise5.services.LibraryException`
* `exercise5.services.LibraryService`
* `exercise5.services.impl.LibraryServiceImpl`

Familiarize yourself with the classes, their contents and the interfaces they 
implement as next you will use them to populate a Spring container.

Under `src/test/resources` you can find an empty Spring configuration file 
`exercise5/TestClient-context.xml`. Configure the implementation of the 
interface `exercise5.services.LibraryService` as a bean in the Spring 
container. Make sure you include everything that the bean requires.

Under `src/test/java` you can find class `exercise5.TestClient` containing some 
JUnit test cases. Run the tests to verify that you have successfully configured 
the beans.

If this was too easy, replace the XML configuration with Java-based container 
configuration. You can find more information in 
[the reference documentation](http://docs.spring.io/spring/docs/current/spring-framework-reference/htmlsingle/#beans-java-basic-concepts).

If you still have time on your hands, create new DAOs using in-memory data 
structures such as a `java.util.Map` and populate them using Spring 
configuration. Use either XML or Java-based configuration.
