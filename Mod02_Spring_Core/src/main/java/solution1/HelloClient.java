/*
 * $Id$
 * Copyright (c) Codecenter Oy. All rights reserved.
 *
 * This software is the proprietary information of Codecenter Oy.
 * Use is subject to license terms.
 */
package solution1;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

public class HelloClient {
    public static void main(String[] args) {
    	// For this solution to work, move the file 
    	// src/main/resources/solution1/helloContext.xml
    	// to the project directory (where pom.xml is located).
        BeanFactory bf = new XmlBeanFactory(new FileSystemResource(
                    "helloContext.xml"));
        HelloService bean = bf.getBean("myHelloService", HelloService.class);
        bean.sayHello();
    }
}
