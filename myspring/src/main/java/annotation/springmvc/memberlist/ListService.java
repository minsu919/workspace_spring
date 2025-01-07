package annotation.springmvc.memberlist;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("listservice")
public class ListService {
	
	@Autowired
	MemberDBDAO dao;
	
	public ArrayList<MemberDTO> getMemberList(int page){
		if (page == 0) {
			return dao.getNonPagingMemberList();
		} else {
			return dao.getPagingMemberList(page, 3);
		}
	}
}
