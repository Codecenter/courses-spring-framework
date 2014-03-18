Use packages `exercise1`, `exercise2` and so on when implementing the exercises. The solutions can be found from corresponding `solution` packages, for example solutions for `exercise1` can be found in package `solution1`.

Exercise 1
----------

In this exercise you'll familiarize yourself with Spring AOP.

Package `exercise1` contains an interface `Utils`. The interface has been implemented by `exercise1.impl.UtilsImpl`.

Under `src/test/java` you can find `exercise1.UtilsTest` which has some tests that can be run against the interface implementation.

Under `src/test/resources` you can find `exercise1/UtilsTest-context.xml` which contains the Spring container configuration used by the JUnit test.

Run the test so see the current output of the project. One of the tests may fail as the target method randomly throws an `IllegalStateException`.

Next your task is to apply various aspects against the interface or the implementation and see how they work in practice.

Start by adding before advice:

1. Add a new class `exercise1.aspect.Analyzer` under `src/main/java`. 
2. Add method `doBefore(JoinPoint joinPoint)` and print something using `System.out.println`. You can study the `JoinPoint` interface and use its methods to print, for example, the name of the target method.
3. Open `exercise1/UtilsTest-context.xml` under `src/test/resources`.
4. Create a bean of type `exercise1.aspect.Analyzer`.
5. Add `<aop:config>` and `<aop:aspect>`. Don't forget to add a reference to the bean from step #1.
6. Use `<aop:before>` to have the method `doBefore` be called on every invocation on the `exercise1.Utils` interface.

Repeat steps 2 and 6 for `after-returning` and `around` advice. Remember that for the around advice you must provide `ProceedingJoinPoint` as the parameter for the advice method. Don't forget to call `proceed()` to continue on the chain of method calls.

For `after-throwing` create a separate class `exercise1.aspect.Logger` without any reference to Spring AOP or AspectJ. Add method `logException(Throwable ex)` and print information about the exception. Declare `after-throwing` aspect in the XML configuration following steps 3-6 for the new aspect class.

[Chapter 8 Aspect Oriented Programming with Spring](http://docs.spring.io/spring/docs/4.0.2.RELEASE/spring-framework-reference/htmlsingle/#aop) will help you with the details, if necessary.

Exercise 2
----------

In this exercise you'll implement a simple profiler which will display the amount of time used on a method call.

Class `exercise2.Application` contains a stand-alone Java application which can be used to run the exercise. 

The implementation is incomplete as the class is missing the construction of Spring container. Under `src/main/resources` you can find `exercise2/fibonacciContainer.xml` which defines two beans. Construct a Spring container in the application class using the XML file.

After the Spring container has been setup you can run the application and see how it works by default.

Which advice type would you use to add a simple profiler displaying the elapsed time of a method call?

In this exercise use @AspectJ annotations instead of XML configuration. Don't forget to add `<aop:aspectj-autoproxy />` to the configuration. Also check out how the `exercise2.Application` uses the beans. Is it using the interface or the concrete class as a type?

