package annotation.springmvc.memberlist;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

@Repository
public class MemberDBDAO {
	
	public ArrayList<MemberDTO>  getPagingMemberList(int pagenumber, int count) {
		ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();

		Connection con = null;
		try {
		Class.forName(DBInfo.driver);
		con = DriverManager.getConnection
				(DBInfo.url, DBInfo.account, DBInfo.password);
		System.out.println("db 연결 성공");
		
		String selectSQL = 
		"select id, name, phone, email, regdate "
		+ "	from(select rownum r,  imsi.* "
		+ " from (select * from members order by regdate desc) imsi)" 
		+ " where r between ? and ?";
		 
		int start = (pagenumber-1)*count + 1;
		int end = pagenumber * count;

		PreparedStatement pt2 = con.prepareStatement(selectSQL);
		pt2.setInt(1,  start);
		pt2.setInt(2,  end);
		ResultSet rs = pt2.executeQuery();//rs 생성되면 첫번째 레코드 참조하는 것이 아니다
		
		while(rs.next()) {
			MemberDTO dto = new MemberDTO();
			dto.setId(rs.getString("id"));
			dto.setName(rs.getString("name"));
			dto.setPhone(rs.getString("phone"));
			dto.setEmail(rs.getString("email"));
			dto.setRegdate(rs.getString("regdate"));
			list.add(dto);
		}
		con.close();
		System.out.println("db 연결 해제 성공");
		//
		}catch(ClassNotFoundException e) {
			System.out.println("잘못된 드라이버이름 혹은 classpath 잘못되었을 수 있습니다.");
			System.out.println("module-info.java 미설정 확인하세요 ");
		}catch(SQLException e) {
			System.out.println("db 연결 실패-연결 정보를 확인하세요");
			e.printStackTrace();//오류발생원인 추적하여 출력
		}finally {
			try {
				if(!con.isClosed()) {
					con.close();
					System.out.println("finally - db 연결 해제 성공");
				}
			}catch(Exception e) {}
		}
		return list;

	}
	
	
	ArrayList<MemberDTO> getNonPagingMemberList(){
		ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();

		Connection con = null;
		try {
		Class.forName(DBInfo.driver);
		con = DriverManager.getConnection
				(DBInfo.url, DBInfo.account, DBInfo.password);
		System.out.println("db 연결 성공");
		
		String selectSQL = 
		"select id, name, phone, email, regdate "
		+ "	from members "
		+ " order by regdate desc ";

		PreparedStatement pt2 = con.prepareStatement(selectSQL);

		ResultSet rs = pt2.executeQuery();//rs 생성되면 첫번째 레코드 참조하는 것이 아니다
		
		while(rs.next()) {
			MemberDTO dto = new MemberDTO();
			dto.setId(rs.getString("id"));
			dto.setName(rs.getString("name"));
			dto.setPhone(rs.getString("phone"));
			dto.setEmail(rs.getString("email"));
			dto.setRegdate(rs.getString("regdate"));
			list.add(dto);
		}
		con.close();
		System.out.println("db 연결 해제 성공");
		//
		}catch(ClassNotFoundException e) {
			System.out.println("잘못된 드라이버이름 혹은 classpath 잘못되었을 수 있습니다.");
			System.out.println("module-info.java 미설정 확인하세요 ");
		}catch(SQLException e) {
			System.out.println("db 연결 실패-연결 정보를 확인하세요");
			e.printStackTrace();//오류발생원인 추적하여 출력
		}finally {
			try {
				if(!con.isClosed()) {
					con.close();
					System.out.println("finally - db 연결 해제 성공");
				}
			}catch(Exception e) {}
		}
		return list;
	}
}
