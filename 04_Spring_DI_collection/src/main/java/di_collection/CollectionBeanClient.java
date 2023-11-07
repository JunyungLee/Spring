package di_collection;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.springframework.context.support.GenericXmlApplicationContext;

public class CollectionBeanClient {

	public static void main(String[] args) {
		System.out.println(">> Spring container 구동 전........");
		
		//1. Spring Container 구동 (스프링 설정 파일 읽어서) 
		GenericXmlApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
		
		System.out.println(">> container 구동 완료 !!");
		
		//2. Spring Container 사용 : 생성된 객체 요청(lookup)
		System.out.println(">> 객체 요청 전");
		CollectionBean bean = (CollectionBean)factory.getBean("collectionBean");
		
		System.out.println(">> 객체 요청 후");
		System.out.println("bean : " + bean);
		
		System.out.println(">> list 타입");
		List<String> addressList = bean.getAddressList();
		for (String address : addressList) {
			System.out.println(address);
		}
		
		System.out.println(">> set 타입");
		Set<String> addressSet = bean.getAddressSet();
		for (String address : addressSet) {
			System.out.println(address); //Set 이기 떄문에 중복 제거 후 2개만 나온다 
		}
		
		System.out.println(">> map 타입");
		Map<String, String> addressMap = bean.getAddressMap();
		System.out.println(addressMap); //Map : 순서 X
		
		System.out.println(">> Properties 타입");
		Properties getaddressProp = bean.getGetAddressProp();
		System.out.println(getaddressProp);
		
		//3. Spring container 종료
		factory.close();

	}

}
