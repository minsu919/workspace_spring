package spring.tv;

public class SamsungTV implements TV {
	
	public SamsungTV() {
		System.out.println("SamsungTV 생성자 호출");
	}
	public void powerOn() {
		System.out.println("삼성티비 전원켜다");
	}
	
	public void powerOff() {
		System.out.println("삼성티비 전원끄다");
	}
	
	public void volumeUp() {
		System.out.println("삼성티비 볼륨올리다");
	}
	
	public void volumeDown() {
		System.out.println("삼성티비 볼륨내리다");
	}
}
