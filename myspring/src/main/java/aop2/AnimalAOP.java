package aop2;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AnimalAOP {
	
	public void before() {
		System.out.println( "오늘은 뭐 먹을거에요" );
	}
	public void after() {
		String now = new SimpleDateFormat("yyyy년도 MM월 dd일").format(new Date() );
		System.out.println(now +  "에 먹었습니다 ");
	}

}
