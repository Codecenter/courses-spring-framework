package solution2;

public class RecursiveFibonacci implements Fibonacci {
	@Override
	public int fibonacci(int n) {
		if (n < 2) {
			return n;
		} 
		else {
			return fibonacci(n - 1) + fibonacci(n - 2);
		}
	}
}
