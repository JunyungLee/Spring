package polymorphism01;

import org.springframework.context.support.GenericXmlApplicationContext;

public class TVUser {
		
		public static void main(String[] args) {
			//spring container 사용 
			System.out.println("--spring container 구동 전--");

			//1. spring container 구동 (spirng 설정 파일 읽어서) 
			GenericXmlApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
			
			//2. spring container 사용 : 생성된 객체를 요청(lookup)
			System.out.println("--- tv 요청 사용 ---");
			TV tv = (TV) factory.getBean("tv");
			System.out.println("tv : " + tv);
			tv.powerOn();
			tv.volumeUp();
			tv.volumeDown();
			tv.powerOff();
			
			System.out.println("--- tv 요청(한번 더) 사용 ---");
			tv = (TV) factory.getBean("tv");
			System.out.println("tv : " + tv);
			tv.powerOn();
			tv.volumeDown();
			tv.powerOff();
			
			//3. spring container close
			factory.close();
		}
}
