package com.springcore.lesson1.AOP;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Aspect
@Slf4j
public class LogAspect {
	//Spring AOP 基礎攔截點  
	
	@Before(value = "execution(public Integer com.springcore.lesson1.AOP.MathJob."
				  + "divide(Integer, Integer) )")
	public void beforeAdvice(JoinPoint joinPoint) {
		String methodname = joinPoint.getSignature().getName();
		Object[] args = joinPoint.getArgs();
		log.info("Before Advice : methodname = " + methodname + ", args = " + Arrays.toString(args) );
	}
	
	@After(value = "execution(public Integer com.springcore.lesson1.AOP.MathJob."
			  	 + "divide(Integer, Integer) )")
	public void AfterAdvice(JoinPoint joinPoint) {
		String methodname = joinPoint.getSignature().getName();
		Object[] args = joinPoint.getArgs();
		log.info("After Advice : methodname = " + methodname + ", args = " + Arrays.toString(args) );
	}
	
	@AfterReturning(value = "execution(public Integer com.springcore.lesson1.AOP.MathJob."
		  	 			  + "divide(Integer, Integer) )")
	public void AfterReturningAdvice(JoinPoint joinPoint) {
		String methodname = joinPoint.getSignature().getName();
		Object[] args = joinPoint.getArgs();
		log.info("AfterReturning Advice : methodname = " + methodname + ", args = " + Arrays.toString(args) );
	}
	
	@AfterThrowing(value = "execution(public Integer com.springcore.lesson1.AOP.MathJob."
 			  			  + "divide(Integer, Integer) )")
	public void AfterThrowingAdvice(JoinPoint joinPoint) {
		String methodname = joinPoint.getSignature().getName();
		Object[] args = joinPoint.getArgs();
		log.info("AfterThrowing Advice : methodname = " + methodname + ", args = " + Arrays.toString(args) );
	}
//	
//	@Around(value = "execution(public Integer com.springcore.lesson1.AOP.MathJob."
//	 			  + "divide(Integer, Integer) )")
//	public void AroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
//		String methodname = joinPoint.getSignature().getName();
//		Object[] args = joinPoint.getArgs();
//		log.info("Around Before Advice : methodname = " + methodname + ", args = " + Arrays.toString(args) );
//		try {
//		  Object result = joinPoint.proceed();
//		  System.err.println(result);
//		  
//		} catch (Throwable e) {
//			log.info("Around AfterThrowing Advice : methodname = " + methodname + ", args = " + Arrays.toString(args) );
//			throw new Throwable(e);
//			//e.printStackTrace();
//		} finally {
//			log.info("Around After Advice : methodname = " + methodname + ", args = " + Arrays.toString(args) );
//		}
//		
//		log.info("Around AfterReturing Advice : methodname = " + methodname + ", args = " + Arrays.toString(args) );
//	}
	
//	@Before(value = "execution(* com.springcore.lesson1..*.*."
//				  + "*(..) )")
//	public void beforeAdvice(JoinPoint joinPoint) {
//		String methodname = joinPoint.getSignature().getName();
//		Object[] args = joinPoint.getArgs();
//		log.info("Before Advice : methodname = " + methodname + ", args = " + Arrays.toString(args) );
//	}
	
//	@Pointcut(value = "execution(* com.springcore.lesson1.AOP.MathJob."
//			  		+ "*(*, *) )" )
//	public void twoAgrsMethodPoint() {
//	}
//	
//	@Pointcut(value = "execution(* com.springcore.lesson1.AOP.MathJob."
//	  		+ "*(*, *, *) )" )
//	public void threeAgrsMethodPoint() {
//	}
//	
//	@Before(value = "twoAgrsMethodPoint()")
//	public void beforeAdvice(JoinPoint joinPoint) {
//		String methodname = joinPoint.getSignature().getName();
//		Object[] args = joinPoint.getArgs();
//		log.info("Before Advice : methodname = " + methodname + ", args = " + Arrays.toString(args) );
//	}
//	
//	@After(value = "threeAgrsMethodPoint() || twoAgrsMethodPoint() ")
//	public void AfterAdvice(JoinPoint joinPoint) {
//		String methodname = joinPoint.getSignature().getName();
//		Object[] args = joinPoint.getArgs();
//		log.info("After Advice : methodname = " + methodname + ", args = " + Arrays.toString(args) );
//	}
	

}
