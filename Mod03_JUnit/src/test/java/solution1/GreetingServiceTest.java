package solution1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("greetingContext.xml")
public class GreetingServiceTest {
	@Autowired
	private GreetingService greetingService;

/* Alternative is to use @Autowired on a set method:
	@Autowired 
	public void setGreetingService(GreetingService greetingService) {
		this.greetingService = greetingService;
	}
*/	
	
	@Test
	public void testValidValue() {
		assertEquals("Hello Jack!", greetingService.sayHello("Jack"));
	}
	
	@Test
	public void testNullValue() {
		assertEquals("Hello !", greetingService.sayHello(null));
	}
	
	@Test
	public void testEmptyValue() {
		assertEquals("Hello !", greetingService.sayHello(""));		
	}
	
	@Test
	public void testWhitespaceValue() {
		assertEquals("Hello !", greetingService.sayHello(" \t\n"));		
	}
}
