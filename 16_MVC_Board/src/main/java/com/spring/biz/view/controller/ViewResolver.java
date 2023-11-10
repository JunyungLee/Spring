package com.spring.biz.view.controller;

//	ViewResolver 클래스는 Controller가 return 한 String(viewName)에
//	접두어(prefix - 경로)와  접미어(suffix - 확장자)를 결합해서 
//	재요청(응답할) 페이지의 경로와 파일명을 완성해서(조합해서) 리턴한다.
public class ViewResolver {
	private String prefix;
	private String suffix;
	
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}
	
	public String getView(String viewName) {
		return prefix + viewName + suffix; 
		//ex> /WEB-INF/views/ + home + .jsp : view 찾아서 응답 처리
		//00_spring_example -> HomeController 참고
	};
}
