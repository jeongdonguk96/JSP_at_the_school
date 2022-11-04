
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SelectServlet")
public class SelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet()으로 작성된 파일입니다.");
		
		String job = request.getParameter("job");
		String[] interests = request.getParameterValues("interest");
		
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		out.print("<h1>GET방식으로 작성된 파일입니다.</h1>");
		out.print("<html><head><title>사용자 입력 정보</title></head>");
		out.print("<body>");
		out.print("사용자가 선택한 직업은 = <b>" + job + "<b><br>");
		out.print("사용자의 관심 분야는 = <b>");
		if(interests==null) {
			out.print("관심분야를 선택하지 않았습니다. 관심분야를 선택해주세요!");
		} else {
			for(String interest : interests) {
				out.print(interest + " ");
			}
		}
		out.print("<br><a href='javascript:history.go(-1)'>뒤로가기</a>"); // 자바스크립트의 함수 중 history.go(), .back, .forward 알기
		out.print("</body></html>");
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
}
