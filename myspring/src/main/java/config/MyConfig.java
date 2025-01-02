package config;

import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

	
	@Configuration // xml 대신 bean 인식
	@ComponentScan(basePackages = "annotation.memberservice")
	public class MyConfig {
	
	@Bean // 메소드 리턴객체 bean 생성 (이름 : getList)
	ArrayList<Integer> getList(){
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(100);
		list.add(200);
		list.add(300);
		return list;
	}
	
	public static void main(String[] args) {
		ApplicationContext factory = new AnnotationConfigApplicationContext(MyConfig.class);
		String[] beans = factory.getBeanDefinitionNames();
		for (String b : beans) {
			System.out.println(b);
		}
//		ArrayList<Integer> list = factory.getBean("getList",ArrayList.class);
//		for (Integer i : list) {
//			System.out.println(i);
//		}

	}

}
