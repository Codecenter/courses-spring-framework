package solution1.aspect;

public class Logger {
	void logException(Throwable ex) {
		System.out.println("Unexpected exception: " + ex.getClass().getName());
//		ex.printStackTrace();
	}
}
