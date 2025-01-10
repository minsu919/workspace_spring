package spring.mybatis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public interface MemberService {
	List<MemberDTO> memberList();
	List<MemberDTO> memberList(String month);
	MemberDTO oneMember(String id);
	String registerMember(MemberDTO dto);
	String modifyMember(MemberDTO dto);
	String deleteMember(String id);
	List<MemberDTO> memberPagingList(ArrayList list);
	List<MemberDTO> memberSearchList(HashMap map);
	List<MemberDTO> memberSearchList(MemberDTO dto);
}
