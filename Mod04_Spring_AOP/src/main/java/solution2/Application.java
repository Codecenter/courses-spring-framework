package solution2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import solution2.aspect.Profiler;

public class Application {
	public static void main(String[] args) {
		final int N = 42;

		ApplicationContext ctx = createContextFromXML();
//		ApplicationContext ctx = createContextFromJavaConfig();
		
		RecursiveFibonacci recursive = ctx.getBean(RecursiveFibonacci.class);
		long startTime = System.currentTimeMillis();
		for (int i = 0; i < N; i++) {
			recursive.fibonacci(i);
		}
		long elapsedTime = System.currentTimeMillis() - startTime;
		System.out.println("Elapsed time for " + N + " calls using recursive method: " + elapsedTime + " ms");
		
		IterativeFibonacci iterative = ctx.getBean(IterativeFibonacci.class);
		startTime = System.currentTimeMillis();
		for (int i = 0; i < N; i++) {
			iterative.fibonacci(i);
		}
		elapsedTime = System.currentTimeMillis() - startTime;
		System.out.println("Elapsed time for " + N + " calls using iterative method: " + elapsedTime + " ms");		
	}
	
	/**
	 * Read Spring configuration from XML.
	 */
	protected static ApplicationContext createContextFromXML() {
		return new ClassPathXmlApplicationContext("solution2/fibonacciContext.xml");
	}

	/**
	 * Read Spring configuration from class JavaConfig (see below).
	 */
	protected static ApplicationContext createContextFromJavaConfig() {
		return new AnnotationConfigApplicationContext(JavaConfig.class);
	}
}

/**
 * This is an example of how to define aspects using Java configuration.
 */
@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = true)
class JavaConfig {
	@Bean
	public RecursiveFibonacci recursiveFibonacci() {
		return new RecursiveFibonacci();
	}

	@Bean
	public IterativeFibonacci iterativeFibonacci() {
		return new IterativeFibonacci();
	}
	
	@Bean
	public Profiler profiler() {
		return new Profiler();
	}
}
