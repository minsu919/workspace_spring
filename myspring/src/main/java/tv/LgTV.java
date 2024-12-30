package tv;

public class LgTV implements TV {
	
	public void powerOn() {
		System.out.println("엘지티비 전원켜다");
	}
	
	public void powerOff() {
		System.out.println("엘지티비 전원끄다");
	}
	
	public void volumeUp() {
		System.out.println("엘지티비 볼륨올리다");
	}
	
	public void volumeDown() {
		System.out.println("엘지티비 볼륨내리다");
	}
}
