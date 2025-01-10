package annotation.springmvc.mybatis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class MemberDAO {
	
	@Autowired
	//@Qualifier("sqlSession")
	SqlSession session;
	
	public List<MemberDTO> memberList(){
		List<MemberDTO> list = session.selectList("a.memberList");
		return list;
	}
	
	public List<MemberDTO> memberList(String month){
		List<MemberDTO> list = session.selectList("memberListMonth", month);
		return list;
	}
	
	public MemberDTO oneMember(String id) {
		return session.selectOne("oneMember",id);
	}

	public int memberCount() {
		return session.selectOne("memberCount");
	}
	
	public int insertMember(MemberDTO dto) {
		return session.insert("insertMemberDTO", dto);
	}
	
	public int updateMember(MemberDTO dto) {
		return session.update("updateMember", dto);
	}
	
	public int deleteMember(String id) {
		return session.delete("deleteMember", id);
	}
	
	public List<MemberDTO> memberPagingList(ArrayList list){
		return session.selectList("memberPagingList", list);
	}
	
	public List<MemberDTO> memberSearchList(HashMap map){
		System.out.println(map);
		return session.selectList("memberSearchList", map);	
	}
	
	public List<MemberDTO> memberSearchList2(MemberDTO dto){
		return session.selectList("memberSearchList2", dto);		
	}
}
