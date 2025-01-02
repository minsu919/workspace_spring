package annotation.memberservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository("dao")
public class MemberDAO {
	@Autowired
	@Qualifier("dto1")
	MemberDTO dto;
	
	MemberDAO(){}
	
	MemberDAO(MemberDTO dto){
		this.dto = dto;
	}
	public void setDto(MemberDTO dto) {
		this.dto = dto;
	}
	
	public void insertMember() {
		// insert sql 사용코드
		System.out.println(dto.getId() + "회원님 정상적으로 회원가입 되셨습니다.");
	}
	
	public boolean selectMember() {
		// select sql 사용코드
		if (dto.getId().equals("spring") && dto.getPw() == 1111) {
			return true;
		} 
		else {
			return false;
		}
	}

}
