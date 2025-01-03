package aop1;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.aspectj.lang.ProceedingJoinPoint;

public class Common { // aop패키지의 모든 메소드 수행 이전에 수
// 메소드 시작 출력
	public void a() {
		System.out.println(
				new SimpleDateFormat("yyyy년도 MM월 dd일 HH시 mm분 ss초에 시작하였습니다.").format(new Date()) );
	}
	
	long start = System.currentTimeMillis();
	public void b() {// target메소드 수행 다음 실행 설정 
		long end = System.currentTimeMillis();
		System.out.println("메소드 수행 시간 (밀리세컨드)=" + (end - start));
	}
	
	public void c(ProceedingJoinPoint joinpoint) { // target메소드 정보 객체
		try {
		// target메소드 전 실행 문장들"
		System.out.println("target 메소드 수행 이전입니다");
		// target 메소드 수행
		Object obj = joinpoint.proceed();
		if (obj != null) {
			System.out.println("메소드의 리턴값 = " + obj);
		}
		System.out.println("target 클래스 이름 = " + joinpoint.getTarget());
		System.out.println("target 메소드 이름 = " + joinpoint.toShortString());
		
		Object[] args = joinpoint.getArgs();
		for (Object o : args) {
			System.out.println("매개변수 = " + o);
		}
		
		// target메소드 후 실행 문장들 
		System.out.println("target 메소드 수행 이후입니다");
		} catch (Throwable e) {
			e.printStackTrace();
		}

	}
// 메소드 종료시간 출력
}