package exercise1;

import java.text.MessageFormat;

import org.springframework.util.StringUtils;

public class DefaultGreetingService implements GreetingService {
	private MessageFormat messageText;

	public DefaultGreetingService(MessageFormat messageText) {
		this.messageText = messageText;
	}

	@Override
	public String sayHello(String name) {
		if (!StringUtils.hasText(name)) {
			name = "";
		}
		return messageText.format(new Object[] { name });
	}
}
