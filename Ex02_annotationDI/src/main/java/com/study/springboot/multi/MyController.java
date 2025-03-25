package com.study.springboot.multi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/*
 * @Controller : bean으로 등록
 				 어떠한 기능을 수행하는 경우에 붙여줌
 		* 주입되어 사용되는 경우 @Component를 붙여줌
 * 
 */
@Controller
public class MyController {
	/*
	@RequestMapping("/")  // get, post의 method를 모두 받음
	public @ResponseBody String root() {// @ResponseBody : html이 아닌 일반 문자를 반환할 때
		return "Annotation 사용하기";
	}
	*/
	@Autowired
	Person Person1;
	
	@Autowired
	@Qualifier("printerB")
	Printer printer;
	
	@Autowired
	Person Person2;
	
	@RequestMapping("/")
	public @ResponseBody String root() {
		System.out.println("person1 : ");
		Person1.print();
		System.out.println("person2 : ");
		Person2.print();
		
		Person1.setPrinter(printer);
		Person1.print();
		
		if(Person1 == Person2) {
			System.out.println("동일한 객체");
		} else {
			System.out.println("다른 객체");
		}
		
		Person2.print();
		
		return "Annotation 사용하기";
	}
}









