package polymorphism03;

public class LG_TV implements TV {
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
