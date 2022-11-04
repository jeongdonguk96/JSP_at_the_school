

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CheckboxServlet")
public class CheckboxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet()에서 실행");
		
		String[] items = request.getParameterValues("item"); // values는 배열을 호출
		
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		out.print("<h1>GET방식으로 작성된 파일입니다.</h1>");
		out.print("<html><head><title>사용자 입력 정보</title></head>");
		out.print("<body>");
		if(items == null) {
			out.print("<h2>선택한 항목이 없습니다. 항목을 선택해주세요!</h2>");
		} else {
			for(String item : items) {
				out.print(item + " ");
			}
		}
		out.print("<br><a href='javascript:history.go(-1)'>뒤로가기</a>"); // 자바스크립트의 함수 중 history.go(), .back, .forward 알기
		out.print("</body></html>");
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
