
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Ex1Servlet")
public class Ex1Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		
		String name = request.getParameter("name");
		String idNum = request.getParameter("idNum") + "-" + request.getParameter("idNum2");
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String email = request.getParameter("email") + "@" + request.getParameter("email2");
		String postNum = request.getParameter("postNum");
		String address = request.getParameter("address") + " " + request.getParameter("address2");
		String phoneNum = request.getParameter("phoneNum");
		String job = request.getParameter("job");
		String chk_mail = request.getParameter("chk_mail");
		String[] interests = request.getParameterValues("interest");
		
		PrintWriter out = response.getWriter();
		
		out.print("<html><head><title>사용자 입력 정보</title></head>");
		out.print("<body>");
		out.print("이름 = <b>" + name + "</b><br>");
		out.print("주민번호 = <b>" + idNum + "</b><br>");
		out.print("아 이 디 = <b>" + id + "</b><br>");
		out.print("비밀번호 = <b>" + pwd + "</b><br>");
		out.print("이 메 일 = <b>" + email + "</b><br>");
		out.print("우편번호 = <b>" + postNum + "</b><br>");
		out.print("주소 = <b>" + address + "</b><br>");
		out.print("핸드폰 = <b>" + phoneNum + "</b><br>");
		out.print("직업 = <b>" + job + "</b><br>");
		out.print("관심분야 = <b>");
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
}
