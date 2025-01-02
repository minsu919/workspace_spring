package memberservice;

public class MemberBasicService implements MemberService {
	
	MemberBasicService(){
		System.out.println("MemberBasicService 객체 생성");
	}
	MemberDAO dao;
	
	public void setDao(MemberDAO dao) {
		this.dao = dao;
	}
	
	@Override
	public void registerMember() {
		// TODO Auto-generated method stub
		boolean b = dao.selectMember();
		if (b == false) {
			dao.insertMember();
		}
	}
}
