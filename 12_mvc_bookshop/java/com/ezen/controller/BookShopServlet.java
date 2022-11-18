package com.ezen.controller;

import java.io.IOException;
import java.sql.Date;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ezen.controller.action.Action;
import com.ezen.dto.ShopBookVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/BookShopServlet")
public class BookShopServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command = null;
		
		//command = request.getParameter("command");
		/*
		 * getAttribute()로 읽은 값이 존재하면 doPost()에서 setAttribute()로 저장한 값임.
		 * 값이 없으면 일반적인 방법으로 화면에서 전달된 데이터를 getParameter()로 읽어줌.
		 */
		if (request.getAttribute("command") != null) {   // multi-part로 입력된 데이터임.
			command = (String)request.getAttribute("command");
			System.out.println("이 요청은 multiPart형식입니다. = " + (String)request.getAttribute("command"));
		} else {
			command = request.getParameter("command");   // multi-part 입력이 아닌 경우
			System.out.println("이 요청은 text형식입니다. = " + request.getParameter("command"));
		}
		
		System.out.println("BookShopServlet에서 받은 command는 = " + command + " 입니다.");
		
		ActionFactory factory = ActionFactory.getInstance();
		Action action = factory.getAction(command);
		
		if(action != null) {
			action.execute(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		ShopBookVO book = new ShopBookVO();
		
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

				if (multi.getParameter("book_id") != null) {
					book.setBook_id(Integer.parseInt(multi.getParameter("book_id")));
				}
				book.setBook_kind(multi.getParameter("book_kind"));
				book.setBook_title(multi.getParameter("book_title"));
				book.setBook_price(Integer.parseInt(multi.getParameter("book_price")));
				book.setBook_count(Integer.parseInt(multi.getParameter("book_count")));
				book.setAuthor(multi.getParameter("author"));
				book.setPublishing_com(multi.getParameter("publishing_com"));
				book.setPublishing_date(multi.getParameter("publishing_date"));
				book.setBook_content(multi.getParameter("book_content"));
				book.setDiscount_rate(Integer.parseInt(multi.getParameter("discount_rate")));
				book.setReg_date(Date.valueOf(multi.getParameter("reg_date")));
				// poster 파일명 설정
				String fileName;
				if (multi.getFilesystemName("book_image") == null) {
					fileName = multi.getParameter("nothing.jpg");
				} else {
					fileName = multi.getFilesystemName("book_image");
				}
				book.setBook_image(fileName);

				request.setAttribute("book", book);
				request.setAttribute("command", multi.getParameter("command"));
				System.out.println("파일의 실제 저장소" + uploadFilePath);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		doGet(request, response);
	}
}
