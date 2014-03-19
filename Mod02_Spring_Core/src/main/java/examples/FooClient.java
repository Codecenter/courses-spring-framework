package examples;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FooClient {
	public static void main(String[] args) throws Exception {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("examples/Foo-context.xml");
		
		Thread.sleep(1000);
		
		FooBean foo = ctx.getBean(FooBean.class);
		
		System.out.println("FooBean.intList: " + foo.getIntList());
	}
}
