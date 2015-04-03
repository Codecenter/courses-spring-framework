/*
 * $Id$
 * Copyright (c) Codecenter Oy. All rights reserved.
 *
 * This software is the proprietary information of Codecenter Oy.
 * Use is subject to license terms.
 */
package examples;

public class SimpleHelloWorld implements HelloWorld {
    @Override
    public void sayHello() {
        System.out.println("Hello from Spring!");
    }
}
