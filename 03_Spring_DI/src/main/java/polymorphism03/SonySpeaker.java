package polymorphism03;

public class SonySpeaker {

	public SonySpeaker() {
		System.out.println("---->> SonySpeaker() 생성");
	}
	
	public void volumeUp() {
		System.out.println(">> SonySpeaker - 소리크게");
	}
	public void volumeDown() {
		System.out.println(">> SonySpeaker - 소리작게");
	}
}
