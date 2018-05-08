package com.example.spring01.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.spring01.MybatisTest;
import com.example.spring01.model.dto.ProductDTO;

@Controller
public class MainController {
	//로깅 변수 
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(MainController.class);
	
	//url mapping
	@RequestMapping("/")
	public String main(Model model) {
		//model에 자료 저장 
		model.addAttribute("message", "홈페이지 방문을 환영합니다");
		//main.jsp로 포워딩 함 
		return "main";
	}

	//url mapping
	@RequestMapping(value = "gugu.do", method = RequestMethod.GET)
//	public String gugu(Model model) {
	public String gugu(@RequestParam(defaultValue = "3") int dan, Model model) {
		
//		int dan = 7;
		String result = "";
		for (int i=1 ; i<=9 ; i++) {
			result += dan + "X" + i + "=" + dan*i +"<br>";
		}
		
		model.addAttribute("result",result);
		
		return "test/gugu";
		//model에 자료 저장 
		//model.addAttribute("message", "홈페이지 방문을 환영합니다");
		//main.jsp로 포워딩 함 
//		return "main";
	}
	@RequestMapping(value="test.do")
	public void test() {
		//WEB-INF/views/test.jsp 
//		return "test";
		//void 없으면 test.jsp로 자동으로 간다
	}

	@RequestMapping(value="test/doA")
	public String doA(Model model) {
		//자료  저장
		model.addAttribute("message","홈페이지 방문을 환영합니다!");
		//포워딩 화면만 바뀜
		return "test/doA";
		//WEB-INF/views/test.jsp 
//		return "test";
		//void 없으면 test.jsp로 자동으로 간다
	}
	
	@RequestMapping(value="test/doB")
	public void doB(Model model) {
		
		logger.info("dbB 호출...");
		//자료  저장
//		model.addAttribute("message","홈페이지 방문을 환영합니다!");
		//포워딩 화면만 바뀜
//		return "test/doA";
		//WEB-INF/views/test.jsp 
//		return "test";
		//void 없으면 test.jsp로 자동으로 간다
	}
	
	//ModelAndView 데이터와 포워딩 할 페이지 정보 포함 
	@RequestMapping(value="test/doC")
	public ModelAndView doB() {
		Map<String,Object> map=new HashMap<>();
		map.put("product", new ProductDTO("샤프",1000));

		return new ModelAndView("test/doC","map",map);
		
	}	
	
	@RequestMapping(value="test/doD")
	public String doD() {
		return "redirect:/test/doE";
	}
	
	@RequestMapping(value="test/doE")
	public void doE() {
	}	

	//뷰를 리턴하는 것이 아닌 데이터 자체를 리턴할 경우
//	@ResponseBody
//	@RequestMapping(value="test/doF")
//	public ProductDTO doF() {
//		return new ProductDTO("냉장고",50000);
//	
//	}
	
	
}
