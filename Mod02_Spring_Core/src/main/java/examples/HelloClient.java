/*
 * $Id$
 * Copyright (c) Codecenter Oy. All rights reserved.
 *
 * This software is the proprietary information of Codecenter Oy.
 * Use is subject to license terms.
 */
package examples;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloClient {
    public static void main(String[] args) {
        BeanFactory bf =
            new ClassPathXmlApplicationContext(
                "examples/applicationContext.xml");
        HelloWorld bean = bf.getBean("myHelloWorld", HelloWorld.class);
        bean.sayHello(); // Use the interface
    }
}
