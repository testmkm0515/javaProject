package com.spring_mvc.projectData;

import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class NewController {
	
	// http://localhost:8080/projectData/
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	//redirect 정리
	//redirect: 접두어 -> 뒤에 나오는 uri로 redirect 진행
	@RequestMapping("/redirect")
	public String redirect(Model model) {
		System.out.println("redirect");
		return "redirect:/showInfo"; // /showInfo 요청을 브라우저가 진행함
		//return "showInfo"; //view 파일을 결정 showInfo.jsp로 view가 결정
	}
	
	//redirect param 정리
	//쿼리스트링 방식으로 파라미터 전달
	@RequestMapping("/redirectParam1")
	public String redirectParam() throws Exception {
		String nation ="대한민국1";
		nation = URLEncoder.encode(nation, "UTF-8");
		return "redirect:/showRedirectParam/?nation="+nation;
	}
	
	@RequestMapping("/redirectParam2")
	public String redirectParam(Model model) throws Exception {
		model.addAttribute("nation","대한민국2"); //redirect되면서 파라미터로 클라이언트에게 전달
		return "redirect:/showRedirectParam";
	}
	
	@RequestMapping("/redirectParam3")
	public String redirectParam(RedirectAttributes reAttr) throws Exception {
		reAttr.addAttribute("nation","대한민국3"); //redirect되면서 파라미터로 클라이언트에게 전달
		return "redirect:/showRedirectParam";		
	}	
	
	//redirect 된 상황이라면 모든 전송데이터는 파라미터로 전송됨
	@RequestMapping("/showRedirectParam")
	public String showParam(@RequestParam("nation") String nation, Model model) {
		System.out.println(nation);
		model.addAttribute("nation",nation);
		return "showRedirectParam";
	}
	
	
	
	
	
	//컨트롤러에서 처리해서 구성한 데이터를 view 페이지인  showInfo.jsp로 전달
	//전달관리는 frontcontroller가 진행
	//showInfo 메소드 : 객체 주입(DI) -> Model 인터페이스가 참조할 수 있는 구현객체 주입
	@RequestMapping("/showInfo")
	public String showInfo(Model model){
		model.addAttribute("name","홍길동");
		model.addAttribute("age", 30);
		//return될때 model객체도 자동으로 프론트컨트롤러에 전달됨  -> 뷰쪽으로 model을 포워딩
		return "showInfo";
	}
	
	//ModelAndView 객체 통해서 data와 view를 프론트컨트롤러에게 반환
	@RequestMapping("/showInfoMV")
	public ModelAndView showInfo2(ModelAndView mv) {
		mv.addObject("name","이몽룡");
		mv.addObject("address", "서울");
		mv.setViewName("showInfoMV"); //showInfoMV.jsp
		return mv;
	}
	
	//Model과 ModelAndView 객체 모두 주입 받기
	@RequestMapping("/showInfo3")
	public ModelAndView showInfo3(Model model,
								  ModelAndView mv) {
		//ModelAndView의 우선순위가 더 높음	
		//mv.addObject("name", "성춘향");
		model.addAttribute("name", "이몽룡");
		mv.addObject("age",23);
		mv.setViewName("showInfo3");
		
		model.addAttribute("address","남원");
		//model은 자동 반환, ModelAndView는 명시적으로 반환
		return mv;
	}
	
	//다중 맵핑 - 표현되는 데이터는 다르지만 view가 동일할 경우 사용
	@RequestMapping(value= {"/book/bookInfoView4","/book/bookInfoView5"})
	public String showBookInfo45(HttpServletRequest request, Model model) {
		if(request.getServletPath().equals("/book/bookInfoView4")) {
			model.addAttribute("title", "java");
			model.addAttribute("priece",35000);
		}else if(request.getServletPath().equals("/book/bookInfoView5")) {
			model.addAttribute("title", "javaFin");
			model.addAttribute("priece",45000);			
		}
		return "book/bookInfoView";
	}
	
}
































