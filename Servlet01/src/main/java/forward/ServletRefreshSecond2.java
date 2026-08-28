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
@WebServlet("/sec02")
public class ServletRefreshSecond2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * redirect 되는 서블릿
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.println("<html><body>");
		out.println("addHeader()를 이용한 refresh 포워딩");
		out.println("</body></html>");
	}

}


















