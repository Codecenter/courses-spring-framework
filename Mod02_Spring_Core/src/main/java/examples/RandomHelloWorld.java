/*
 * $Id$
 * Copyright (c) Codecenter Oy. All rights reserved.
 *
 * This software is the proprietary information of Codecenter Oy.
 * Use is subject to license terms.
 */
package examples;

import java.util.List;
import java.util.Random;

public class RandomHelloWorld implements HelloWorld {
    private List<String> messages;
    private Random rand = new Random();

    public RandomHelloWorld(List<String> messages) {
        this.messages = messages;
    }

    @Override
    public void sayHello() {
        System.out.println(messages.get(rand.nextInt(messages.size())));
    }
}
