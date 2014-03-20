package solution4;

public class HelloServiceImpl implements HelloService {
    private String messageText = "Hello World!";

    public HelloServiceImpl() {
    }

    public HelloServiceImpl(String messageText) {
        setMessageText(messageText);
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        if (messageText == null) {
            throw new IllegalArgumentException("Message cannot be null");
        }
        this.messageText = messageText;
    }

    @Override
    public void sayHello() {
        System.out.println(messageText);
    }
}
