package aop2;

public class Rabbit implements Animal {

	@Override
	public String lunch() {
		System.out.println(" 풀을 먹었습니다. ");
		return "Rabbit-풀";
	}
}
