package memberservice;

public class MemberPointService implements MemberService{
	
	MemberDAO dao;
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
			//dao2.setPoint(1000);
		}
	}
}
