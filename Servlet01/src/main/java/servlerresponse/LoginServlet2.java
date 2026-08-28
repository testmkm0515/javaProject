package servlerresponse;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * get/post 요청시 처리 내용이 동일하다면 
 * 처리 메소드를 새로 생성해서 처리만 담당하게 진행
 * doProcess(request, response) doHandle(request, response)
 */
@WebServlet(name = "Login", urlPatterns = { "/login3" })
public class LoginServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * 톰캣에 의해 호출 : 외부시스템과 접목되는 지점 -> 비지니스 처리를 진행하지는 않음	 
	 * 
	 * 
	 * */	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("get 요청");
		doHandle(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("post 요청");
		doHandle(request, response);
	}
	
	//doGet/doPost로부터 요청 받아서 처리하는 메소드 -> 톰캣(was)버퍼에 응답할 데이터를 출력
	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		System.out.println("doHandle 작업");
		//(1)클라이언트로부터 요청받음 : 요청처리
		request.setCharacterEncoding("utf-8");
		String userId = request.getParameter("user_id");
		String userPw = request.getParameter("user_pw");
		
		//(2)클라이언트에게 응답 처리
		//2-1. MIME TYPE 및 char-set 지정 -> response.setContentType("")
		response.setContentType("text/html;charset=utf-8");
		//2-2. 톰캣으로 출력할 때 사용할 출력기 생성 -> 객체는 response 객체로부터 반환
		PrintWriter out = response.getWriter();
		
		out.println("<html><head></head><body>");
		out.println("아이디 : " + userId + "<br>");
		out.println("비밀번호 : " + userPw + "<br>");
		out.println("</body></html>");		
	}

}












