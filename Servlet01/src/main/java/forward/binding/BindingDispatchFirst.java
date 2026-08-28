package forward.binding;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * banding : request.setAttribute("속성명", 속성값)
 *  */
@WebServlet("/dispatchfirst")
public class BindingDispatchFirst extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * 호출될 때 전달받은  request 객체에 속성을 포함하여 포워딩
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		request.setAttribute("name", "홍길동");
		request.setAttribute("address", "서울시 강남구");
		
		RequestDispatcher dispatch = request.getRequestDispatcher("dispatchsecond");
		dispatch.forward(request, response);
	}

}









