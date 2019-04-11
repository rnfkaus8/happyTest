package com.happy.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspWriter;

import org.apache.log4j.Logger;

import com.happy.dao.AnswerBoard_Impl;
import com.happy.dao.IAnswerBoardDao;

@WebServlet("/FileDown")
public class FileDown extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logger logger = Logger.getLogger(FileDown.class);
    public FileDown() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		System.out.println("전체조회 페이지 이동");
		IAnswerBoardDao aDao = new AnswerBoard_Impl();
		String fileName = request.getParameter("fileName");
		
		ServletContext context = getServletContext();
		String downloadPath = context.getRealPath("upload");
		
		//다운 받을 파일의 경로
		String filePath = downloadPath+"\\"+fileName;
		File file = new File(filePath);
		
		//읽어올 파일의 유형을 알아보기 위함
		String mimeType = getServletContext().getMimeType(filePath);
		if(mimeType==null){
			// 유형이 알려지지 않은 파일에 대한 읽기 형식을 일련된
			// 8bit 스트림 형식으로 설정
			mimeType = "application/octet-stream";
		}
		
		// 파일 유형을 알려줌
		response.setContentType(mimeType);
		
		// 다운로드 설정 및 한글 파일명 깨지는 것을 방지
		String encA = "UTF-8";
//	 	String encB = new String(fileName.getBytes("euc-kr"), "8859_1");
//	 	String encoding = URLEncoder.encode(encA, encB);
		
		// 내용들을 헤더에 올려 다운로드시 화면에 출력
		response.setHeader("content-Disposition", "attachment; filename="+fileName);
		
		// 요청 파일을 읽어서 클라이언트에 전송
		FileInputStream in = new FileInputStream(file);
		
		// 브라우저에 쓰기
		ServletOutputStream outStream = response.getOutputStream();
		
		// 읽어와야 할 파일의 최대 용량이 다운로드 시 용량을 넘지 않기 때문에
		// 업로드 시 설정했던 용량 만큼 설정
		byte b[] = new byte[1024*1024*10];
		int data = 0;
		
		// 바이트 배열 b의 0번부터 길이까지 브라우저로 출력
		while((data=in.read(b, 0, b.length))!= -1){
			outStream.write(b,0,data);
		}
		
		outStream.flush();
		outStream.close();
		in.close();
	}
	public void forwardDispatcher(String url, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		logger.info(url + "로 이동함");
		dispatcher.forward(request, response);
	}
}
