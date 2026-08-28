package forward.memberbinding;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * VO 객체를 ArrayList에 추가해서 Binding 하는 예시
 * 비즈니스 로직 처리 클래스로 가정
 */
@WebServlet("/memBinding")
public class MemberBindingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//VO 객체 각각에 여러명의 회원정보를 저장하고 ArrayList에 담아서 출력을 담당하는 서블릿쪽으로 포워딩 -> 바인딩
		MemberVO vo1 = new MemberVO("kim", "1234", "김길동", "kim@naver.com");
		MemberVO vo2 = new MemberVO("lee", "2222", "이길동", "lee@naver.com");
		MemberVO vo3 = new MemberVO("park", "3333", "박길동", "park@naver.com");
		
		ArrayList<MemberVO> memList = new ArrayList<>();
		memList.add(vo1);
		memList.add(vo2);
		memList.add(vo3);
		
		//ArrayList 데이터 바인딩
		request.setAttribute("memList", memList);
		
		//포워딩
		RequestDispatcher dispatch = request.getRequestDispatcher("memView");
		dispatch.forward(request, response);
	}

}





















