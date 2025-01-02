package di_exam2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("testService")
public class TestServiceImpl implements TestService{
	
	@Autowired
	private TestDAO dao;

	public TestDAO getDao() {
		return dao;
	}

	public void setDao(TestDAO dao) {
		this.dao = dao;
	}

	public TestVO test() {
		System.out.println("TestServiceImpl : test() ");
		dao.test();
		return dao.getVo();
	}
}
