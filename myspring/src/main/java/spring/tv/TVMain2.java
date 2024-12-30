package spring.tv;


import tv.TVFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TVMain2 {

	public static void main(String[] args) {
		// 외부에서 TV객체 전달받는다 / 직접 TV객체 생성하지 않는다.
		// spring tv.xml 설정에 있는 객체 생성 요청
		ApplicationContext factory = new ClassPathXmlApplicationContext("spring/tv/tv.xml");
		//TV tv = (TV)factory.getBean("tv");
		
		TV tv1 = factory.getBean("tv1", TV.class);
		TV tv2 = factory.getBean("tv2", TV.class);
		TV[] tvs = {tv1, tv2}; 
		for (TV tv : tvs) {
			
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

}
