package servletrequest;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 동일 파라미터명으로 여러개의 값이 전송되는 경우
 */
@WebServlet("/input")
public class InputServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * get/post 요청 처리가 동일한경우 한곳에서만 처리
	 * 동일 파라미터명으로 파라미터값이 전달되는 경우
	 * getParameterValues("파라미터명") -> 문자열 배열 반환
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		String emailRcv = request.getParameter("emailRcv");//라디오버튼은 동일 이름의 태그가 있어도 단일 선택으로 한개값만 전송
		//체크박스인 경우 동일 name 속성으로 여러개의 값이 전달 -> 배열로 받음
		String[] subject = request.getParameterValues("subject");
		
		System.out.println("아이디 : "+ user_id);
		System.out.println("비밀번호 : "+ user_pw);
		System.out.println("이메일 수신여부 : "+ emailRcv);
		
		System.out.println("선택한 과목 : ");
		for(String sub:subject) {
			System.out.print(sub + " ");
		}
	}

}












