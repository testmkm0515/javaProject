package servlet01;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SecondServlet
 */
@WebServlet("/secondAnnot") //SecondServlet 클래스의 별명(servlet path) -> uri -> url
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * 객체 생성 시 1번 호출
	 */
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init2");
	}

	/**
	 * 코드 업데이트 또는 서버 종료 시 1번 호출
	 */
	public void destroy() {
		System.out.println("destory2");
	}

	/**
	 * 클라이언트 Get method 요청이 있을 때 마다 호출
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet");
	}

}
