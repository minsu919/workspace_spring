package di_exam1;


public class TestDAO {
	
	private TestVO vo;
	
	public TestDAO(){}
	
	public TestDAO(TestVO vo) {
		this.vo = vo;
	}
	
	public TestVO getVo() {
		return vo;
	}

	public void setVo(TestVO vo) {
		this.vo = vo;
	}
	
	public TestVO test(){
		System.out.println("TestVO : test() ");
		return vo;
	}
}
