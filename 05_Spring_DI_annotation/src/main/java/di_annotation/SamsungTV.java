package di_annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

//@Component : 객체 생성
//@Component : 명칭 생략시 samsungTV 명칭 사용(class명 : 첫글자 소문자)
@Component("tv")
public class SamsungTV implements TV {
	//필드에 @Autowired, @Qualifier 어노테이션 설정
	//@Autowired //동일한 데이터 타입을 찾아서 주입
	//@Qualifier("apple") //@Qualifier를 통해 객체 지정 : 명칭으로 찾아서 적용  => @Autowired와 같이 사용(단독으로 사용할 수 없다)
	private Speaker speaker; 
	private int price;
	private int width;
	private int height;
	
	@Autowired
	public SamsungTV(@Qualifier("apple")Speaker speaker) {
		System.out.println(">> SamsungTV(speaker) 객체 생성");
		this.speaker = speaker;
	}
	public SamsungTV(Speaker speaker, int price) {
		System.out.println(">> SamsungTV(speaker, price) 객체 생성");
		this.speaker = speaker;
		this.price = price;
	}
	public SamsungTV(Speaker speaker, int width, int height) {
		System.out.println(">> SamsungTV(speaker, width, height) 객체 생성");
		this.speaker = speaker;
		this.width = width;
		this.height = height;
	}
	
	@Override
	public void powerOn() {
		System.out.println("SamsungTV - 전원ON");
	}
	@Override
	public void powerOff() {
		System.out.println("SamsungTV - 전원OFF");
	}
	@Override
	public void volumeUp() {
		System.out.println("SamsungTV - 소리크게");
		speaker.volumeUp();
	}
	@Override
	public void volumeDown() {
		System.out.println("SamsungTV - 소리작게");
		speaker.volumeDown();
	}
	@Override
	public String toString() {
		return "SamsungTV [speaker=" + speaker + ", price=" + price + ", width=" + width + ", height=" + height + "]";
	}
	
	//======= getter, setter ==============
	public Speaker getSpeaker() {
		return speaker;
	}
	public void setSpeaker(Speaker speaker) {
		this.speaker = speaker;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}

	
	

}








