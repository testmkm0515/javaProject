package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MemberDAO;
import model.MemberVO;

/*
 * /member/로 시작하는 모든 uri(servelt path)
 * /member/abc , /member/list....
 * /member/요청의 frontcontroller
 */
@WebServlet("/member/*")
public class MemberControllerFront extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MemberDAO memberDAO ;
	
	public void init() throws ServletException {
		memberDAO = new MemberDAO(); //초기화 메소드에서 DAO 생성
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}
	
	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nextPage = null; //forward 시킬 location 저장
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String action = request.getPathInfo(); //서블릿에 전달된 최종 경로만 반환 /member는 현재 서블릿이 제거했음
		System.out.println("action : " + action); //해당 함수에 전달되는 경로는 /member 뒤의 경로만 반환
		// /member/list로 요청했다면 action에는 /list를 저장하게됨
		
		// /member/listMembers.do 또는 /member -> 회원목록
		if(action == null || action.equals("/listMembers.do")) {
			List<MemberVO> membersList = memberDAO.listMembers();
			request.setAttribute("membersList", membersList);
			nextPage = "/view/listMembers.jsp"; //포워딩될 url
		}else if(action.equals("/memberForm.do")){
			nextPage ="/view/memberForm.jsp";
			
		}else if(action.equals("/addMember.do")) {//회원가입 진행 후
			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd");
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			MemberVO memVO = new MemberVO(id, pwd, name, email);
			memberDAO.addMember(memVO); //회원가입 완료
			
			request.setAttribute("msg", "addMember");			
			
			//금방 가입된 결과를 포함하는 회원 목록을 확인
			nextPage = "/member/listMembers.do";
		}else if(action.equals("/modMemberForm.do")) { //회원정보 수정
			String id = request.getParameter("id");
			MemberVO memInfo = memberDAO.findMember(id);//수정한다고 하는 회원 정보 데이터를 반환
			request.setAttribute("memInfo", memInfo);
			nextPage="/view/modMemberForm.jsp";
		}else if(action.equals("/modMember.do")) {
			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd");
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			String joinDate = request.getParameter("joinDate");
			System.out.println(id+" "+pwd+" "+name+" "+email+" "+joinDate);
			MemberVO memVO = new MemberVO(id, pwd, name, email);
			memberDAO.modMember(memVO);
			
			request.setAttribute("msg", "modified");
			nextPage="/member/listMembers.do";
		}else if(action.equals("/delMember.do")) {
			String id = request.getParameter("id");
			memberDAO.delMember(id);
			request.setAttribute("msg", "deleted");
			nextPage="/member/listMembers.do";
		}else {
			List<MemberVO> membersList = memberDAO.listMembers();
			request.setAttribute("membersList", membersList);
			nextPage = "/view/listMembers.jsp";	
		}		
		RequestDispatcher dispatch = request.getRequestDispatcher(nextPage);
		dispatch.forward(request, response);
		
	}

}




