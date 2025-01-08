package mybatis;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MemberMain {

	public static void main(String[] args) throws IOException, SQLException {
		// mybatis/mybatis-config.xml 을 읽어오기
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		SqlSessionFactory factory = 
				builder.build( Resources.getResourceAsReader("mybatis/mybatis-config.xml"));
		//SqlSession session = factory.openSession();
		SqlSession session = factory.openSession(true); //autocommit statement
		System.out.println(session.getConnection().getAutoCommit());
		/////////////////////////////////////////////////////////////////////
		/*
		 * List<MemberDTO> list = session.selectList("a.memberList"); for (MemberDTO dto
		 * : list) { System.out.println(dto.getId() + ":" + dto.getName() + ":" +
		 * dto.getEmail()); }
		 */
		
		/*
		 * MemberDTO dto = session.selectOne("oneMember", "jdbc1");
		 * System.out.println(dto.getId() + ":" + dto.getName());
		 */
		
		/*
		 * int count = session.selectOne("memberCount"); System.out.println("전체회원수=" +
		 * count);
		 */
		
		/*
		 * int rows = session.insert("insertMember"); System.out.println("가입한 회원수=" +
		 * rows);
		 */
		//session.commit();
		
//		MemberDTO dto = new MemberDTO();
//		dto.setId("mybatis4");
//		dto.setName("마이티");
//		dto.setPw(14141);
//		dto.setPhone("010-3567-5432");
//		dto.setEmail("m@ybatis.net");
//		int rows = session.insert("insertMemberDTO", dto);
//		
//		System.out.println("가입한 회원수=" + rows);
		
//		MemberDTO dto = new MemberDTO();
//		dto.setId("mybatis4");
//		dto.setPw(14444);
//		dto.setPhone("010-3117-5432");
//		dto.setEmail("m4432@ybatis.net");
//		int rows = session.insert("updateMember", dto);
//		
//		System.out.println("가입한 회원수=" + rows);
		
//		int rows = session.delete("deleteMember", "mybatis4");
	}

}
