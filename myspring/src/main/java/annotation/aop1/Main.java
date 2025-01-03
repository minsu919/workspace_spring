package annotation.aop1;

import java.util.ArrayList;
import java.util.Calendar;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import annotation.memberservice.MemberPointService;
import annotation.memberservice.MemberService;

@Configuration
@ComponentScan(basePackages = "annotation.aop1")
@EnableAspectJAutoProxy
@ImportResource("/annotation/memberservice/member.xml")
public class Main {

	public static void main(String[] args) {
		//ApplicationContext factory = new ClassPathXmlApplicationContext("annotation/aop1/aop1.xml");
		ApplicationContext factory = new AnnotationConfigApplicationContext(Main.class);
		
		Member member = factory.getBean("member", Member.class);
		System.out.println("=======================");
		member.login("aoptest");
		System.out.println("=======================");
		
		System.out.println("=======================");
		member.logout();
		System.out.println("=======================");
		
		Board board = factory.getBean("board", Board.class);
		System.out.println("=======================");
		board.insert(6);
		System.out.println("=======================");

		System.out.println("=======================");
		board.getList();
//		ArrayList<String> list = board.getList(); // common.c 실행 처리 
//		for (String s: list) {
//			System.out.println(s);
//		}
		System.out.println("=======================");
		
		
		//member.xml 빈
		int month = Calendar.getInstance().get(Calendar.MONTH);
		MemberService service = null;
		if (month == 0 || month == 5 /*|| month == 11*/) {
			service = factory.getBean("pointservice", MemberService.class);
		}
		else {
			service = factory.getBean("basicservice", MemberService.class);
		}
		service.registerMember();
		
		if (service instanceof MemberPointService) {
		System.out.println( "point = " + ((MemberPointService)service).getDao2().getPoint() + " 입니다.");
		}

	}

}
