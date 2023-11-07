package di_annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//(실습)Speaker 추가하고 @Component, @Autowired, @Qualifier 추가해서 설정 
@Component
public class LgTV implements TV {
	
	@Autowired
	private Speaker speaker;
	private int price;
	private int width;
	private int height;
	
	public LgTV() { //default constructor 
		System.out.println(">> LgTV() 객체 생성");
	}
	
	public LgTV(Speaker speaker) {
		System.out.println(">> LgTV() 객체 생성");
		this.speaker = speaker;
	}
	
	public LgTV(Speaker speaker, int price) {
		super();
		this.speaker = speaker;
		this.price = price;
	}

	public LgTV(Speaker speaker, int price, int width, int height) {
		super();
		this.speaker = speaker;
		this.price = price;
		this.width = width;
		this.height = height;
	}
	
	@Override
	public void powerOn() {
		System.out.println("LgTV - 전원ON");
	}
	@Override
	public void powerOff() {
		System.out.println("LgTV - 전원OFF");
	}
	@Override
	public void volumeUp() {
		System.out.println("LgTV - 소리크게~~~");
		speaker.volumeUp();
	}
	@Override
	public void volumeDown() {
		System.out.println("LgTV - 소리작게~~~");
		speaker.volumeDown();
	}
	
	//----------Speaker getter & setter --------
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
