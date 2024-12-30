package tv;

public class TVMain {

	public static void main(String[] args) {
		// 외부에서 TV객체 전달받는다 / 직접 TV객체 생성하지 않는다.
		TV tv = new TVFactory().getTV(args[0]);
		if(tv != null) {
			tv.powerOn();
			tv.volumeDown();
			tv.volumeUp();
			tv.powerOff();		
		}
		else {
			System.out.println("공장에서 취급 안하는 브랜드입니다");
		}
		
	}

}
