package annotation.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("dao3") // id=memberDAO
public class MemberDAO {
	
	@Autowired  // 여러개 있다면 선택 (dto3, memberDTO)
	@Qualifier("dto2")
	MemberDTO dto;
	
	MemberDAO (){}
	MemberDAO(MemberDTO dto){
		this.dto = dto;
	}
	public void setDto(MemberDTO dto) {
		this.dto = dto;
	}
	
	public void insertMember() {
		System.out.println(dto.getId() + "회원님 정상적으로 회원가입 되셨습니다.");
	}
	
	public boolean selectMember() {
		// id = spring , pw = 1111 true
		if (dto.getId().equals("spring") && dto.getPw() == 1111) {
			return true;
		} else return false;
	}

}
