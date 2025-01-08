package mybatis;

import java.util.List;

public interface MemberService {
	List<MemberDTO> memberList();
	List<MemberDTO> memberList(String month);
	MemberDTO oneMember(String id);
	String registerMember(MemberDTO dto);
	String modifyMember(MemberDTO dto);
	String deleteMember(String id);
	
}
