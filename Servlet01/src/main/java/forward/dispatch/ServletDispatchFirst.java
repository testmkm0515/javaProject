package forward.dispatch;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletDispatchFirst
 */
@WebServlet("/dispatch01")
public class ServletDispatchFirst extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 *RequestDispatcher 클래스 이용한 포워딩 
	 *서버 내부에서 서블릿을 재요청 진행하는 상황이어서 클라이언트는 포워딩 여부 알 수없음
	 *포워딩 된 후에도 클라이언트 요청 주소는 초기 요청 주소가 표현
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = "홍길동";
		int age =30;
		//get 방식 요청에 payload를 추가해서 url 구성 - 내부 통신 이므로 인코딩 안해도 됨
		RequestDispatcher dispatch = request.getRequestDispatcher("dispatch02?name="+name+"&age="+age);
		dispatch.forward(request, response); //클라이언트 정보 전달(request, response)
	}

}
