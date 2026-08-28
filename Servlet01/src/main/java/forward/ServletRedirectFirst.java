package forward;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletRedirectFirst
 */
@WebServlet("/first01")
public class ServletRedirectFirst extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * 해당 요청을 sec01 servlet 에게 redirect 
	 * 클라이언트에게 redirection 응답이 진행되게 됨
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf8");
		response.sendRedirect("sec01");//맵핑된 url이 http://localhost:8080/Servlet01/sec01 요청을 브라우저가 다시 진행하게 됨
	}

}
