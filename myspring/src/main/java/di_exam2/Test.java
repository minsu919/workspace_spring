package di_exam2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {

		ApplicationContext factory = new ClassPathXmlApplicationContext("di_exam2/test.xml");

		TestServiceImpl testService = (TestServiceImpl) (factory.getBean("testService"));

		TestVO vo = testService.test();
		System.out.println(vo.getMember1() + " : " + vo.getMember2());

	}
}
