package annotation.member;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MemberMain {

	public static void main(String[] args) {
		
		ApplicationContext factory = new ClassPathXmlApplicationContext("annotation/member/member.xml");
//		String beans[] = factory.getBeanDefinitionNames();
//		for (String name : beans) {
//			System.out.println(name);
//		}
		MemberDAO dao = factory.getBean("dao3", MemberDAO.class);
		// @AutoWired MemberDTO dto; 선언
		// 자동 주입
		MemberDTO dto = factory.getBean("dto3", MemberDTO.class); //ok
		System.out.println(dto);
		System.out.println(dto.getId());
		boolean result = dao.selectMember();
		if (result) {
			System.out.println(dao.dto.getId() + " 님 정상 로그인 사용자입니다.");
	    }
		else {
			dao.insertMember();
		}

//		MemberDAO dao2 = factory.getBean("dao2", MemberDAO.class);
//		boolean result2 = dao2.selectMember();
//		if (result2) {
//			System.out.println(dao2.dto.getId() + " 님 정상 로그인 사용자입니다.");
//		}
//		else {
//			dao2.insertMember();	
//		}
	}

}
