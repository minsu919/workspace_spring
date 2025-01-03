package annotation.aop1;

import org.springframework.stereotype.Component;

@Component
public class Member {
	void login(String id) {
		System.out.println(id + " 회원님이 로그인하셨습니다.");
	}
	
	public void logout() {
		System.out.println("로그아웃하셨습니다.");
	}
}
