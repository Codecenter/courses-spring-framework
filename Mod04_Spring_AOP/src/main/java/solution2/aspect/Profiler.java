package solution2.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class Profiler {
	@Around("execution(int solution2.*.fibonacci(int))")
	public Object profileMethod(ProceedingJoinPoint joinPoint) throws Throwable {
		long startTime = System.currentTimeMillis();
		Object retVal = joinPoint.proceed();
		long elapsedTime = System.currentTimeMillis() - startTime;
		System.out.println(joinPoint.getSignature().getDeclaringTypeName() 
				+ ": Elapsed time " + elapsedTime + " ms");
		return retVal;
	}
}
