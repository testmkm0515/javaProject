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
@WebServlet("/sec01")
public class ServletRedirectSecond extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * redirect 되는 서블릿
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.println("<html><body>");
		out.println("sendRedirect를 이용한 redirect 포워딩");
		out.println("</body></html>");
	}

}


















