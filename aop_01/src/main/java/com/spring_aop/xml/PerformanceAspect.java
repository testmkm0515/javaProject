package com.spring_aop.xml;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/* 
 * 공통기능
 * 공통기능 메소드 포함
 * 시작시간 종료시간 출력의 기능을 핵심기능의 공통사항 가정
 * Gugudan 클래스와 Rect클래스의 핵심기능메소드 수행 전/후에 시간 출력 *  
 */

// 공통기능에 사용할 클래스(Proxy에 해당)\
@Aspect
public class PerformanceAspect {
	
	//where : 어디에 적용할 것인지(annotation 패키지 내 모든 클래스
	@Pointcut("within(com.spring_aop.annotation.*)")
	private void pointcutMethod() { //annotation을 부착하고 이름을 사용하기위한 용도 -> 빈메소드 구성
		
	}
	
	//when: 핵심기능 메소드 전에 trace 시작하고 핵심기능 위임 trace 메소드의 나머지를 실행
	@Around("pointcutMethod()")
	public Object trace(ProceedingJoinPoint joinPoint) throws Throwable{
			Signature s = joinPoint.getSignature(); //joinpoint의 정보 추출
			String methodName = s.getName(); //핵심기능 메소드 이름 추출
			
			System.out.println("--------------------------------");
			System.out.println("[LOG]Before:"+methodName+"() :실행 시작");
			System.out.println("--------------------------------");
			
			long startTime = System.nanoTime();
			Object result = null;
			
			try {
				result = joinPoint.proceed(); //핵심기능 수행
			}catch(Exception e){
				System.out.println("[LOG]Exception: "+methodName);
			}
			
			long endTime = System.nanoTime();

			System.out.println("--------------------------------");
			System.out.println("[LOG]After:"+methodName+"() :실행 종료");
			System.out.println("[LOG]:"+methodName+"() 실행시간:"+(endTime-startTime)+"ns");
			System.out.println("--------------------------------");		
			
			return result;
	}

}
