package tv;

public class TVFactory {
	
	TV getTV(String name) {
		if (name.equals("삼성")) {
			return new SamsungTV();
		} else if (name.equals("엘지")) {
			return new LgTV();
		} else 
			return null;
	}
	
}
