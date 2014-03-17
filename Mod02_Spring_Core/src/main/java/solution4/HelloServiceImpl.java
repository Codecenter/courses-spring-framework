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

    public void setMessageText(String MessageText) {
        if (MessageText == null) {
            throw new IllegalArgumentException("Message cannot be null");
        }
        this.messageText = MessageText;
    }

    @Override
    public void sayHello() {
        System.out.println(messageText);
    }
}
