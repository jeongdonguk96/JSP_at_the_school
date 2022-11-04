
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RadioServlet")
public class RadioServlet extends HttpServlet { // text가 아닌 radio 버튼을 출력
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet()에서 실행");
		
		String chkMail = request.getParameter("chk_mail");
		String gender = request.getParameter("gender");
		String content = request.getParameter("content");
		
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		out.print("<h1>GET방식으로 작성된 파일입니다.</h1>");
		out.print("<html><head><title>사용자 입력 정보</title></head>");
		out.print("<body><h1>사용자가 입력한 정보입니다.</h1>");
		out.print("메일 수신여부 = <b>" + chkMail  + "</b><br>");
		out.print("성별 = <b>" + gender + "</b><br>");
		out.print("가입인사 = <b><pre>" + content + "</pre></b><br>");
		out.print("<a href='javascript:history.go(-1)'>뒤로가기</a>"); // 자바스크립트의 함수 중 history.go(), .back, .forward 알기 
		out.print("</body></html>");
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost()에서 실행");
		doGet(request, response);
	}

}
