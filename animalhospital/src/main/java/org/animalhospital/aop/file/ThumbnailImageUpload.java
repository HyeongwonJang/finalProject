package org.animalhospital.aop.file;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ThumbnailImageUpload {

	/*@Around("execution(public * org.animalhospital.petowner.service.register.*(..))")
	public Object uploadSingleImage(ProceedingJoinPoint point) throws Throwable{
		Object[] args = point.getArgs();
		Object retValue = null;
		for(int i=0; i<args.length; i++){
			System.out.println("aop 작동테스트: " + args[i]);
		}
		retValue = point.proceed();
		
		return retValue;
	}*/
}
