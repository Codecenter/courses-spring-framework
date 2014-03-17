Exercise 1
----------

In this exercise you'll code the classic Hello World using Spring Framework's basic features.

Create an interface `exercise1.HelloService` and store it in `src/main/java`. Define a single method `void sayHello()`.

Next you'll implement the interface in class `exercise1.HelloServiceImpl`. Implement the method `sayHello()` by printing text "Hello World!" using `System.out.println`.

Create a file named `helloContext.xml` in the project root folder (where the pom.xml is located). You can copy XML schema definitions from the example below:

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
3. Using the `XmlBeanFactory` obtain the bean named "myHelloService" using `getBean`. Use the javadoc of the `BeanFactory` interface to find a suitable method, if necessary.
4. If necessary, perform type cast to the `HelloService` interrface and call the `sayHello` method.
5. Make sure that `HelloClient` does not reference the actual implementation `HelloServiceImpl`, but is aware only of the interface `HelloService`.

Run the application and verify that it works as intended.

Exercise 2
----------

Copy all types from the previous exercise to package `exercise2`. Make sure all copied classes now refer to the new package!

Copy Spring configuration file `helloContext.xml` to class path resource folder `src/main/resources`. Place the file to package `exercise2`. Add missing directories, if necessary.

Edit the class `exercise2.HelloClient` to use `ClassPathResource` instead of `FileSystemResource` in the previous exercise. Pass the constructor value `exercise2/helloContext.xml`.

Run the application and verify that it works as intended.

Exercise 3
----------

Copy all types from the previous exercise to package `exercise3`. Make sure all copied classes now refer to the new package!

Edit class exercise3.HelloServiceImpl implementation to use `ClassPathXmlApplicationContext` instead of `XmlBeanFactory`.

Run the application and verify that it works as intended.

Exercise 4
----------

Copy all types from the previous exercise to package `exercise4`. Make sure all copied classes now refer to the new package!

Edit class exercise4.HelloServiceImpl implementation so that the message text can be specified using attribute `messageText`. Decide how you want the attribute value to be set (a set method or constructor or both). Then use the Spring configuration to set attribute value to "Hola!". 

Run the application and verify that it works as intended.

Exercise 5
----------

Copy all types from the previous exercise to package exercise5. You can delete the class exercise5.HelloClient because it is not used in this exercise.

Add a JUnit test class to src/test/java source folder using class name exercise4.HelloServiceTest:

1. Define an attribute of type HelloService. You can use any name you want.
2. Add method testHelloService() and annotate it using @Test. Implement the method by calling HelloService attribute's sayHello method.
3. Annotate the test class with @RunWith(SpringJUnit4ClassRunner.class) and @ContextConfiguration.
4. Annotate the HelloService attribute with  @Resource. Alternatively you can also add a set method for the attribute and annotate it instead.
5. Create the Spring configuration in file exercise5/HelloServiceTest-context.xml under src/test/resources.

Run the JUnit test and verify that it works as intended.

Exercise 6
----------

The project template for the exercise contains the following classes and interfaces:

* fi.codecenter.library.dao.AuthorDAO
* fi.codecenter.library.dao.BookDAO
* fi.codecenter.library.dao.jdbc.JDBCAuthorDAO
* fi.codecenter.library.dao.jdbc.JDBCBookDAO
* fi.codecenter.library.model.Author
* fi.codecenter.library.model.Book
* fi.codecenter.library.services.LibraryException
* fi.codecenter.library.services.LibraryService
* fi.codecenter.library.services.impl.LibraryServiceImpl

Familiarize yourself with the classes, their contents and the interfaces they implement as next you will use them to populate a Spring container.

Under src/test/resources you can find an empty Spring configuration file exercise6/TestClient-context.xml. Configure the implementation for the interface fi.codecenter.library.services.LibraryService as a bean in the Spring container. Make sure you include everything that the bean requires.

Under src/test/java you can find class exercise6.TestClient containing some JUnit test cases. Run the tests to verify that you have successfully configured the beans.
