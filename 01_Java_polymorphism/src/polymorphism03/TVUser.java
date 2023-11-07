package polymorphism03;

import java.util.Arrays;

public class TVUser {
		
		public static void main(String[] args) {
			System.out.println("args : " + Arrays.toString(args));
			BeanFactory factory = new BeanFactory();

			//Samsung TV 사용
//			TV tv = (TV) factory.getBean("samsung");
			//LG TV 사용
//			TV tv = (TV) factory.getBean("lg");
			
			
			TV tv = (TV) factory.getBean(args[0]);
			System.out.println("tv : " + tv);
			tv.powerOn();
			tv.volumeUp();
			tv.volumeDown();
			tv.powerOff();
		}
}
