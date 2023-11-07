package polymorphism02;

public class TVUser {
		
		public static void main(String[] args) {
			//삼성 TV 사용 -> Lg TV 사용
			//SamsungTV tv = new SamsungTV();
			//LG_TV tv = new LG_TV();
			TV tv = new LG_TV();
			tv.powerOn();
			tv.volumeUp();
			tv.volumeDown();
			tv.powerOff();
		}
}
