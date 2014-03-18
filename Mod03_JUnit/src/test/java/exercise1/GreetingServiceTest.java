package exercise1;

import static org.junit.Assert.assertEquals;

public class GreetingServiceTest {
	private GreetingService greetingService;

	public void testValidValue() {
		assertEquals("Hello Jack!", greetingService.sayHello("Jack"));
	}
	
	public void testNullValue() {
		assertEquals("Hello !", greetingService.sayHello(null));
	}
	
	public void testEmptyValue() {
		assertEquals("Hello !", greetingService.sayHello(""));		
	}
	
	public void testWhitespaceValue() {
		assertEquals("Hello !", greetingService.sayHello(" \t\n"));		
	}
}
