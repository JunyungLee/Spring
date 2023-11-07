package di_annotation;

import org.springframework.context.support.GenericXmlApplicationContext;

public class TVUser {

	public static void main(String[] args) {
		//스프링 컨테이너 사용
		System.out.println("--- 스프링 컨테이너 구동전 ----");
		//1. 스프링 컨테이너 구동(스프링 설정 파일 읽어서)
		GenericXmlApplicationContext factory
				= new GenericXmlApplicationContext("applicationContext.xml");
		
		//2. 스프링 컨테이너 사용 : 생성된 객체 요청(lookup)
		//인터페이스를 구현하는 클래스를 사용함으로써 결합도를 낮출 수 있으며 주입되는 타입의 영향을 덜 받을 수 있다. 
		System.out.println("--- tv 요청 사용 ----");
		TV tv = (TV) factory.getBean("tv2");
		System.out.println("tv : " + tv);
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
		
		//3. 스프링 컨테이너 종료(close)
		factory.close();
	}
}







