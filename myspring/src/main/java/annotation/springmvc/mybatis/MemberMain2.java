package annotation.springmvc.mybatis;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class MemberMain2 {
	public static void main(String[] args) throws IOException, SQLException {
		
		ApplicationContext factory = new ClassPathXmlApplicationContext
				("spring/mybatis/spring-mybatis.xml");
		
		MemberService service = factory.getBean("memberServiceImpl", MemberService.class);
		// 12월에 가입한 회원 조회
		// 호출한 결과를 리턴받아 출력
		// 12월에 가입한 회원의 아이디 이름 가입일 출력
//		System.out.println("===12월 가입 회원===");
//		List<MemberDTO> list = service.memberList("12");
//		for (MemberDTO dto : list) {
//			System.out.println(dto.getId() + ":" + dto.getName() + ":" + dto.getRegdate());
//		}
		
		// 페이징 처리
//		ArrayList<Integer> mypage = new ArrayList();
//		mypage.add(4);
//		mypage.add(6);
//		
//		List<MemberDTO> paginglist = service.memberPagingList(mypage);
//			for (MemberDTO dto : paginglist) {
//				System.out.println(
//				dto.getId() + ":" + dto.getName() + ":" + dto.getRegdate());
//				
//			}
		
		// 검색을 위해 map 전송
//		HashMap<String, String> map = new HashMap();
//		map.put("colname", "id");
//		map.put("colvalue", "jdbc%");
//		map.put("colname", "name");
//		map.put("colvalue", "김%");
//		map.put("colname", "email");
//		map.put("colvalue", "%multi%");
//		List<MemberDTO> searchlist = service.memberSearchList(map);
//		for (MemberDTO dto : searchlist) {
//			System.out.println(
//			dto.getId() + ":" + dto.getName() + ":" + dto.getRegdate() + ":" + dto.getEmail());
//			
//		}
		
		System.out.println("===회원 리스트===");
		List<MemberDTO> list = service.memberList();
		for (MemberDTO dto : list) {
			System.out.println(dto.getId() + ":" + dto.getName() + ":" + dto.getEmail());
		}
		System.out.println("총회원 수 = " + list.get(list.size()-1).getPw());
		
		System.out.println("===1명의 회원정보===");
		MemberDTO dto1 = service.oneMember("jdbc1");
		System.out.println(dto1.getId() + ":" + dto1.getName());
//		
//		System.out.println("===회원 가입===");
//		MemberDTO dto2 = new MemberDTO();
//		dto2.setId("mybatis4");
//		dto2.setName("마이티");
//		dto2.setPw(14141);
//		dto2.setPhone("010-3567-5432");
//		dto2.setEmail("m@ybatis.net");
//		
//		String result = service.registerMember(dto2);
//
//		System.out.println("가입결과 = " + result);
//		
//		System.out.println("===회원 정보수정===");
//		MemberDTO dto3 = new MemberDTO();
//		dto3.setId("mybatis4");
//		dto3.setPw(14444);
//		dto3.setPhone("010-3127-5112");
//		dto3.setEmail("m1234@ybatis.net");
//		
//		String result2 = service.modifyMember(dto3);
//		System.out.println("수정결과 = " + result2);
//		
//		System.out.println("===회원 탈퇴===");
//		String result3 = service.deleteMember("mybatis4");
//		System.out.println("탈퇴결과 = " + result3);
		
		
		MemberDTO dto = new MemberDTO();
		dto.setName("%김%");
		List<MemberDTO> searchlist2 = service.memberSearchList(dto);
		for (MemberDTO dto2 : searchlist2) {
		System.out.println(
				dto2.getId() + ":" + dto2.getName() + ":" + dto2.getRegdate() + ":" + dto2.getEmail()
		+ ":" + dto2.getPhone() + ":" + dto2.getRegdate());
		
		}
		
//		MemberDTO dto = new MemberDTO();
//		dto.setId("jdbc");
//		MemberDTO resultdto = session.selectOne("totalsql",dto);
//		for (MemberDTO dto2 : searchlist2) {
//		System.out.println(
//				dto2.getId() + ":" + dto2.getName() + ":" + dto2.getRegdate() + ":" + dto2.getEmail()
//		+ ":" + dto2.getPhone() + ":" + dto2.getRegdate());
//		
//		}
	}
}