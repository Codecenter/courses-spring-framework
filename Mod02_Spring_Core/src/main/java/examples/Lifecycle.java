package examples;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Lifecycle {
	public static void main(String[] args) throws Exception {
		ConfigurableApplicationContext ctx = 
				new ClassPathXmlApplicationContext("examples/Lifecycle-context.xml");
		
		ctx.getBean(FooBean.class);
		
		ctx.close();
	}
}
