package forward.binding;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 바인딩된 정보를 추출해서 클라이언트에게 응답데이터로 보냄
 */
@WebServlet("/dispatchsecond")
public class BindingDispatchSecond extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * request 객체가 포워딩될 때 같이 전달
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String name = (String)request.getAttribute("name"); //반환값의 타입은 Object -> 형변환
		String address = (String)request.getAttribute("address");
		
		PrintWriter out = response.getWriter();
		
		out.println("<html><body>");
		out.println("성명 : " + name + "<br>");
		out.println("주소 : " + address + "<br>");
		out.println("</body></html>");
	}

}











