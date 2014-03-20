Use packages `exercise1`, `exercise2` and so on when implementing the exercises. The solutions can be found from corresponding `solution` packages, for example solutions for `exercise1` can be found in package `solution1`.

Exercise 1
----------

In this exercise you'll wire up a `GreetingService` and then configure an existing test class to perform some tests on the service.

1. Familiarize yourself with the interface `exercise1.GreetingService` and its implementation `exercise1.DefaultGreetingService`. If necessary, use [Java 7 API documentation](http://docs.oracle.com/javase/7/docs/api/) to see how `java.text.MessageFormat` is set up. Hint: you can use `{0}` in the pattern to refer to the `name` parameter of `sayHello`.
2. Add the service to the Spring container configuration in `exercise1/greetingContext.xml` found under `src/main/resources`.
3. Add JUnit and Spring annotations to `exercise1.GreetingServiceTest` under `src/test/java`. The code is ready, but all the annotations are missing.

Run the tests and verify that it works as intended.
