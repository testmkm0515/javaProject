package forward;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Redirect 방식으로 다른 서블릿에 데이터 전달하기
 */
@WebServlet("/first04")
public class ServletDataFirst extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		//String name = "lee";
		String name = "홍길동";
		//유니코드 문자 [홍]은(는), 0에서 255까지의 허용 범위 바깥에 있으므로 인코딩될 수 없습니다 - 인코딩 필요
		//한글이 url에 포함되면 URLEncoder 활용해서 url char로 인코딩
		String encodedName = URLEncoder.encode(name,"utf-8");
		System.out.println(encodedName);
		int age = 30;
		response.sendRedirect("sec04?name="+encodedName+"&age="+age);//url의 페이로드가 한글이 포함됨
	}

}
