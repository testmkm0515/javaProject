package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MemberDAO;
import model.MemberDTO;

//webserver로부터 요청을 받아서 처리할 클래스에게 처리 신호 보냄
//처리된 결과를 view(jsp)로 포워딩을 진행
@WebServlet("/memberSelect")
public class ControlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request,response);
	}
	
	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		
		//비즈니스로직처리 요청
		MemberDAO dao = new MemberDAO();
		ArrayList<MemberDTO> memList = dao.memberSelect();
		//처리된 결과를 view로 전달->바인딩
		request.setAttribute("memList", memList);
		//포워딩되는 url은 jsp view
		RequestDispatcher dispatch = request.getRequestDispatcher("view/memberListView.jsp");
		dispatch.forward(request, response); //request단의 attribute memList 전송됨
	}	

}



















