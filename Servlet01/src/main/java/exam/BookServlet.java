package exam;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 클라이언트가 form 태그통해 전송한 데이터(파라미터)를 추출해서 처리
 */
@WebServlet("/bookInsert")
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init(ServletConfig config) throws ServletException {
		System.out.print("객체 생성");
	}

	/**
	 * form method post 요청 처리
	 * 1개의 파라미터 value를 추출할 때 사용 : getParameter (input type text, password, radio 1개 값 전송)
	 * 동일 파라미터명으로 여러개의 파라미터가 전송되면 getParameter는 처음 보이는 파라미터의 값만 반환
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			request.setCharacterEncoding("utf-8");
			String bookNo = request.getParameter("bookNo");
			String bookName = request.getParameter("bookName");
			
			System.out.println("도서번호 : " + bookNo);
			System.out.println("도서명   : " + bookName);
	}

}
