package ojdbc;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 컨트롤러 역할을 하는 서블릿 : 요청을 받아서 처리를 진행할 클래스를 결정하고 반환되는 결과를 view로 전달 응답하도록 관리
 * 비즈니스로직 처리 기능 호출해서 view로 전달
 */
@WebServlet("/memberselect")
public class MemberSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}
	
	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDAO dao = new MemberDAO();
		ArrayList<MemberVO> memList = dao.memberSelect();
		
		request.setAttribute("memList", memList);
		
		RequestDispatcher dispatch = request.getRequestDispatcher("memberView");
		dispatch.forward(request, response);
	}	

}
