package di_annotation;

public class AppleSpeaker implements Speaker {
	
	public AppleSpeaker() {
		System.out.println(">> AppleSpeaker() 객체 생성");
	}
	
	@Override
	public void volumeUp() {
		System.out.println("> AppleSpeaker() 소리 크게");
	}
	@Override
	public void volumeDown() {
		System.out.println("> AppleSpeaker() 소리 작게");
	}
}
