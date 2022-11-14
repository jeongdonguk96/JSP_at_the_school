package com.ezen.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/multi_upload.do")
public class MultiUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		request.setCharacterEncoding("utf-8");
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
		
		Enumeration<String> files = multi.getFileNames();
		
		while(files.hasMoreElements()) { // 다음 내용(파일)이 있으면(없을 때까지)
			String file = files.nextElement(); // 다음 내용(파일)을 file에 담음
			String fileName = multi.getFilesystemName(file); // 내용(파일)의 업로드 이름을 fileName에 담음
			String originFile = multi.getOriginalFileName(file); // 내용(파일)의 실제 이름을 originFile에 담음
			
			out.print("업로드 파일명 : " + fileName + "<br>");
			out.print("원본 파일명 : " + originFile + "<br>");
			out.print("<hr />");
		}
	}
}
