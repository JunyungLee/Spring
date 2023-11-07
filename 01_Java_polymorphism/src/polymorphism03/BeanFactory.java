package polymorphism03;

public class BeanFactory {
	
	//Factory 패턴을 적용해서 결합도를 낮춤
	// TV를 만들어주는 공장역할 클래스의 메소드
	public Object getBean(String beanName) {
		Object bean = null;
		if ("samsung".equals(beanName)) {
			bean = new SamsungTV();
		} else if ("lg".equals(beanName)) {
			bean = new LG_TV();
		}
		
		return bean;
	}
}
