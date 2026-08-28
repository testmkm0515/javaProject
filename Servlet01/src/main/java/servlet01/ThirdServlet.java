package servlet01;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Get방식의 요청(브라우저 주소줄을 이용해 직접 주소 입력 요청)
 * 서블릿에 doGet() 포함되지 않으면
 * 서블릿 객체는 생성됨 -> 요청 처리를 진행할 메소드가 없으므로 요청 처리 불가(응답불가)
 * 웹서버는 무조건 응답해야 하므로 응답 불가 상황에 대한 에러 페이지를 응답하게 됨
 */
@WebServlet("/ThirdServlet")
public class ThirdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ThirdServlet() {
        super();
        
    }

	/**
	 * 
	 */
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init");
	}

	/**
	 *
	 */
	public void destroy() {
		System.out.println("destory");
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet");
		doPost(request, response);
	}

	/**
	 * Get방식의 요청에는 호출되지 않는 메소드
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost");
	}

}
