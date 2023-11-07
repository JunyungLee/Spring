package polymorphism01;

public class LG_TV implements TV {
		public LG_TV() {
			System.out.println(">> LG_TV() 객체 생성");
		}
		
		@Override
		public void powerOn() {
			System.out.println("LG TV 전원 On");
		}
		@Override
		public void powerOff() {
			System.out.println("LG TV 전원 Off");
		}
		@Override
		public void volumeUp() {
			System.out.println("LG TV 소리 크게~");
		}
		@Override
		public void volumeDown() {
			System.out.println("LG TV 소리 작게~");
		}
}
