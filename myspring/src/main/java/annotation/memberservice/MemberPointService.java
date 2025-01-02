package annotation.memberservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("pointservice")
public class MemberPointService implements MemberService{
	
	@Autowired
	MemberDAO dao;
	
	@Autowired
	PointDAO dao2;
	
	public MemberPointService() {
		System.out.println("MemberPointService 객체 생성 ");
	}
	
	
	public MemberDAO getDao() {
		return dao;
	}


	public void setDao(MemberDAO dao) {
		this.dao = dao;
	}


	public PointDAO getDao2() {
		return dao2;
	}


	public void setDao2(PointDAO dao2) {
		this.dao2 = dao2;
	}

	@Override
	public void registerMember() {
		boolean b = dao.selectMember();
		if (b == false) {
			dao.insertMember();
		}
	}
}
