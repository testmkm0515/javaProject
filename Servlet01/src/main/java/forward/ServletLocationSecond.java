package forward;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletRedirectSecond
 */
@WebServlet("/sec03")
public class ServletLocationSecond extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * javascript로 포워딩 되는 서블릿
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.println("<html><body>");
		out.println("자바스크립트에 의해 요청:location.href");
		out.println("</body></html>");
	}

}


















