package polymorphism01;

public class TVUser {
		
		public static void main(String[] args) {
			//삼성 TV 사용
//			SamsungTV tv = new SamsungTV(); //객체생성
//			tv.powerOn();
//			tv.volumeUP();
//			tv.volumeDown();
//			tv.powerOff();
			
			//LG TV 사용형태로 변경
			LG_TV tv = new LG_TV(); 
			tv.on();
			tv.soundUp();
			tv.soundDown();
			tv.off();
		}
}
