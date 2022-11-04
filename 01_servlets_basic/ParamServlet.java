
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ParamServlet")
public class ParamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ParamServlet() {

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet()에서 실행");
		
		// 사용자 입력정보 읽기
		String id = request.getParameter("id"); // getParameter는 String타입
		int age = Integer.parseInt(request.getParameter("age")); // int로 받고 싶다면 형변환하기
		
		System.out.println("id = " + id);
		System.out.println("age = " + age);
		
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter(); // web창에 출력이 나오도록 하는 객체
		
		out.print("<h1>GET방식으로 작성된 파일입니다.</h1>");
		out.print("<html><head><title>사용자 입력 정보</title></head>");
		out.print("<body><h1>사용자가 입력한 정보입니다.</h1>");
		out.print("아이디 = " + id + "<br>");
		out.print("나 이 = " + age + "<br>");
		out.print("</body></html>");
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost()에서 실행");
		request.setCharacterEncoding("utf-8"); // get방식에서는 자동변환 되지만 post는 인코딩 설정 해야함
		
		// 사용자 입력정보 읽기
		String id = request.getParameter("id"); // getParameter는 String타입
		int age = Integer.parseInt(request.getParameter("age")); // int로 받고 싶다면 형변환하기
		
		System.out.println("id = " + id);
		System.out.println("age = " + age);
		
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();  // web창에 출력이 나오도록 하는 객체
		
		out.print("<h1>POST방식으로 작성된 파일입니다.</h1>");
		out.print("<html><head><title>사용자 입력 정보</title></head>");
		out.print("<body><h1>사용자가 입력한 정보입니다.</h1>");
		out.print("아이디 = " + id + "<br>");
		out.print("나 이 = " + age + "<br>");
		out.print("</body></html>");
		out.close();
	}
}
