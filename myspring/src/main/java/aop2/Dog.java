package aop2;

public class Dog implements Animal {
	
	@Override
	public String lunch() {
		System.out.println(" 사료를 먹었습니다 "); 
		return "Dog-사료";
	}
}
