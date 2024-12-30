package member;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MemberMain {

	public static void main(String[] args) {
		
		ApplicationContext factory = new ClassPathXmlApplicationContext("member/member.xml");
		MemberDAO dao = factory.getBean("dao", MemberDAO.class);
		boolean result = dao.selectMember();
		if (result) {
			System.out.println(dao.dto.getId() + " 님 정상 로그인 사용자입니다.");
		}
		else {
			dao.insertMember();
		}

	}

}
