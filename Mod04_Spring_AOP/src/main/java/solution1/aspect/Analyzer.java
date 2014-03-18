package solution1.aspect;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class Analyzer {
	public void doBefore(JoinPoint joinPoint) {
		System.out.println("doBefore: " + joinPoint.getSignature());
	} 

	public void doAfterReturning(JoinPoint joinPoint, Object returnValue) {
		System.out.println("doAfterReturning: " + joinPoint.getSignature() 
				+ ", returnValue=" + returnValue);
	}

	public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("doAround(1): " + joinPoint.getSignature() 
				+ ", args=" + Arrays.toString(joinPoint.getArgs()));
		
		// Continue the method call.
		Object returnValue = joinPoint.proceed();
		
		System.out.println("doAround(2): " + joinPoint.getSignature() 
				+ ", args=" + Arrays.toString(joinPoint.getArgs())
				+ ", returnValue=" + returnValue);
		return returnValue;
	}
}
