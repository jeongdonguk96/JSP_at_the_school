package com.ezen.controller;

import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.ezen.controller.action.Action;
import com.ezen.dto.MovieVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/MovieServlet")
public class MovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command = null;
		
		//command = request.getParameter("command");
		/*
		 * getAttribute()로 읽은 값이 존재하면 doPost()에서 setAttribute()로 저장한 값임.
		 * 값이 없으면 일반적인 방법으로 화면에서 전달된 데이터를 getParameter()로 읽어줌.
		 */
		System.out.println("text 경우 request.getParameter(\"command\") = " + request.getParameter("command"));
		System.out.println("multipart 경우 (String)request.getAttribute(\"command\") = " + (String)request.getAttribute("command"));
		if (request.getAttribute("command") != null) {   // multi-part로 입력된 데이터임.
			command = (String)request.getAttribute("command");
		} else {
			command = request.getParameter("command");   // multi-part 입력이 아닌 경우
		}
		
		System.out.println("MovieServlet에서 요청 수신" + command);
		
		ActionFactory factory = ActionFactory.getInstance();
		Action action = factory.getAction(command);
		
		if(action != null) {
			action.execute(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		MovieVO vo = new MovieVO();
		
		String savePath = "images"; // 업로드 파일을 저장할 폴더를 savePath로 담음
		int uploadFileSize = 10 * 1024 * 1024; // 5MB, 기본이 Byte인데 1024를 곱해주면 단위가 하나씩 늠
		String encType = "utf-8"; // 인코딩 방식을 encType에 담음
		
		// 업로드 파일을 저장할 실제 경로 구하기
		ServletContext context = getServletContext(); // 프로젝트의 정보를 얻어오기
		String uploadFilePath = context.getRealPath(savePath); // 파일이 저장될 실제 경로
		
		// Multipart로 전송된 데이터는 일반적인 getParameter()로 읽을 수 없으므로
		// Multipart 객체를 생성해서 얻은 파라미터를 내장객체에 저장하여 doGet()으로 넘겨줌.
		
		if (request.getParameter("command") == null) { // command 입력값이 null이면 MultipartRequest로 전송된다고 가정함
			try {
				MultipartRequest multi = new MultipartRequest(
						request, uploadFilePath,
						uploadFileSize, encType,
						new DefaultFileRenamePolicy()
						);

				if (multi.getParameter("code") != null) {  // 영화정보 Update인 경우
					vo.setCode(Integer.parseInt(multi.getParameter("code")));
				}
				
				vo.setTitle(multi.getParameter("title"));
				vo.setPrice(Integer.parseInt(multi.getParameter("price")));
				vo.setDirector(multi.getParameter("director"));
				vo.setActor(multi.getParameter("actor"));
				vo.setSynopsis(multi.getParameter("synopsis"));
				// poster 파일명 설정
				String fileName;
				if (multi.getFilesystemName("poster") == null) {
					fileName = multi.getParameter("nonmakeImg");
				} else {
					fileName = multi.getFilesystemName("poster");
				}
				vo.setPoster(fileName);

				request.setAttribute("movie", vo);
				request.setAttribute("command", multi.getParameter("command"));

			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		doGet(request, response);
	}

}
