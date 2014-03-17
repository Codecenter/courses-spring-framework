Exercise solutions can be found by replacing Java package `exercise` with `solution`, for example replace `exercise1` with `solution1`.

Exercise 1
----------

In this exercise you'll code the classic Hello World using Spring Framework's basic features.

Create an interface `exercise1.HelloService` and store it in `src/main/java`. Define a single method `void sayHello()`.

Next you'll implement the interface in class `exercise1.HelloServiceImpl`. Implement the method `sayHello()` by printing text "Hello World!" using `System.out.println`.

Create a file named `helloContext.xml` in the project root folder (where the `pom.xml` is located). You can copy XML schema definitions from the example below:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
                           http://www.springframework.org/schema/beans/spring-beans.xsd">
 
</beans>
```

Define a single Spring bean named "myHelloService" using the previously created class `exercise1.HelloServiceImpl`.

Finally add a new application class `exercise1.HelloClient`:

1. Add method `public static void main(String[] args)` so that the application can be started.
2. In the main method construct an `XmlBeanFactory` instance by calling the constructor with a `FileSystemResource` object with path `helloContext.xml`. The path is relative to the folder where the application is started (ie. the project's root folder).
3. Using the `XmlBeanFactory` obtain the bean named "myHelloService" using `getBean`. Use [the javadoc](http://docs.spring.io/spring/docs/4.0.2.RELEASE/javadoc-api/index.html?org/springframework/beans/factory/BeanFactory.html) of the `BeanFactory` interface to find a suitable method, if necessary.
4. If necessary, perform type cast to the `HelloService` interrface and call the `sayHello` method.
5. Make sure that `HelloClient` does not reference the actual implementation `HelloServiceImpl`, but is aware only of the interface `HelloService`.

Run the application and verify that it works as intended.

Exercise 2
----------

Copy all types from the previous exercise to package `exercise2`. Make sure all copied classes now refer to the new package!

Copy Spring configuration file `helloContext.xml` to class path resource folder `src/main/resources`. Place the file to package `exercise2`. Add missing directories, if necessary.

Edit class `exercise2.HelloClient` to use `ClassPathResource` instead of `FileSystemResource` in the previous exercise. Pass the constructor value `exercise2/helloContext.xml`.

Run the application and verify that it works as intended.

Exercise 3
----------

Copy all types from the previous exercise to package `exercise3`. Make sure all copied classes now refer to the new package!

Edit class `exercise3.HelloServiceImpl` implementation to use `ClassPathXmlApplicationContext` instead of `XmlBeanFactory`.

Run the application and verify that it works as intended.

Exercise 4
----------

Copy all types from the previous exercise to package `exercise4`. Make sure all copied classes now refer to the new package!

Edit class `exercise4.HelloServiceImpl` implementation so that the message text can be specified using attribute `messageText`. Decide how you want the attribute value to be set (a set method or constructor or both). Then use the Spring configuration to set attribute value to "Hola!". 

Run the application and verify that it works as intended.

Exercise 5
----------

The project template for the exercise contains the following classes and interfaces:

* `exercise5dao.AuthorDAO`
* `exercise5dao.BookDAO`
* `exercise5dao.jdbc.JDBCAuthorDAO`
* `exercise5dao.jdbc.JDBCBookDAO`
* `exercise5model.Author`
* `exercise5model.Book`
* `exercise5services.LibraryException`
* `exercise5services.LibraryService`
* `exercise5services.impl.LibraryServiceImpl`

Familiarize yourself with the classes, their contents and the interfaces they implement as next you will use them to populate a Spring container.

Under `src/test/resources` you can find an empty Spring configuration file `exercise5/TestClient-context.xml`. Configure the implementation for the interface `exercise5services.LibraryService` as a bean in the Spring container. Make sure you include everything that the bean requires.

Under `src/test/java` you can find class `exercise5.TestClient` containing some JUnit test cases. Run the tests to verify that you have successfully configured the beans.

If this was too easy, replace the XML configuration with Java-based container configuration. You can find more information in [the reference documentation](http://docs.spring.io/spring/docs/4.0.2.RELEASE/spring-framework-reference/htmlsingle/#beans-java-basic-concepts).

If you still have time on your hands, create new DAOs using in-memory data structures such as a `java.util.Map` and populate them using Spring configuration. Use either XML or Java-based configuration.
