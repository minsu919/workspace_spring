package annotation.memberservice;

import java.util.Calendar;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MemberMain {

	public static void main(String[] args) {
		
		ApplicationContext factory = new ClassPathXmlApplicationContext("annotation/memberservice/member.xml");
		
		/*
		 * 현재 날짜 오늘 몇월 조사
		 * 1, 6 ,12 월은 포인트 MemberPointService;register()
		 * 나머지 월 - MemberBasicService:register()
		 * MemberPointService 객체 생성
		 * */
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
		System.out.println( "point = " + ((MemberPointService)service).dao2.point + " 입니다.");
		}
	}

}
