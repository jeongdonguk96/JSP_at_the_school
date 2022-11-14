package com.ezen.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/upload.do")
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
	
	// file은 파일 용량이 크기 때문에 무조건 post방식을 실행한다. (get방식은 최대 255byte)
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String savePath = "upload"; // 업로드 파일을 저장할 폴더를 savePath로 담음
		int uploadFileSize = 5 * 1024 * 1024; // 5MB, 기본이 Byte인데 1024를 곱해주면 단위가 하나씩 늠
		String encType = "utf-8"; // 인코딩 방식을 encType에 담음
		
		// 업로드 파일을 저장할 실제 경로 구하기
		ServletContext context = getServletContext(); // 프로젝트의 정보를 얻어오기
		String uploadFilePath = context.getRealPath(savePath);
		System.out.println("upload파일의 실제 경로 : " + uploadFilePath);
		
		// 사용자의 업로드 데이터를 저장
		MultipartRequest multi = new MultipartRequest(request, uploadFilePath, uploadFileSize, encType, new DefaultFileRenamePolicy());
											// 받아올 객체(request), 컴퓨터에 저장할 실제 경로, 파일의 최대 크기, 인코딩 방식, 중복 처리 방식(default)
		
		// 화면에서 업로드한 파일 이름 가져오기
		String fileName = multi.getFilesystemName("upload_file"); // 파라미터로 jsp에서 지정한 파일의 이름
		
		if(fileName == null) { // 업로드한 파일이 없을 경우(이 경우엔 이름이 있을 수 없으니)
			out.print("파일이 업로드되지 않았습니다.");
		} else {
			out.print("글쓴이 : " + multi.getParameter("writer") + "<br>");
			out.print("제목 : " + multi.getParameter("title") + "<br>");
			out.print("파일명 : " + fileName + "<br>");
		}
	}
}
