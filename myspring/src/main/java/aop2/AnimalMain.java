package aop2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnimalMain {

	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("aop2/aop2.xml");
		Animal animals[] = new Animal[3];
		animals[0] = factory.getBean("cat", Cat.class);
		animals[1] = factory.getBean("rabbit", Rabbit.class);
		animals[2] = factory.getBean("dog", Dog.class);
		
		for (Animal animal : animals) {
			animal.lunch();
		}
		
		/* 오늘은 뭐 먹을거에요 
		 * Cat - 생선 xxxx년도 xx일 (오늘 날짜) 먹었습니다. 
		 * Dog - 사료 먹었습니다.
		 * Rabbit - 당근 먹었습니다.
		 * 
		 * 
		 * */

	}

}
