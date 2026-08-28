package servlerresponse;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 서블릿의 응답처리
 */
@WebServlet(name = "LoginServlet2", urlPatterns = { "/login2" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * 응답처리 과정
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
