package forward.binding;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * redirect 된 경우 binding 적용되는지 확인
 */
@WebServlet("/bindingsecond")
public class BindingRedirectSecond extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * binding은 request.Attribute 구조에 포함시켜서 전달됨
	 * 추출 : request.getAttribute("attr 이름");
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		//bindingsecond는 새로운 request와 response를 전달 받음 -> Attribute 없음
		//null 반환
		String name = (String)request.getAttribute("name");
		String address = (String)request.getAttribute("address");
		
		out.println("<html><body>");
		out.println("성명 : " + name + "<br>");
		out.println("주소 : " + address + "<br>");
		out.println("</body></html>");
	}

}




