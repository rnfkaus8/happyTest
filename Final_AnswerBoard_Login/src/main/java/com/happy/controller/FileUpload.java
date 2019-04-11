package com.happy.controller;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.happy.dao.AnswerBoard_Impl;
import com.happy.dao.IAnswerBoardDao;
import com.happy.dto.AnswerBoard_DTO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/FileUpload")
public class FileUpload extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logger logger = Logger.getLogger(BoardList.class);
    public FileUpload() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		System.out.println("전체조회 페이지 이동");
		IAnswerBoardDao aDao = new AnswerBoard_Impl();
		String path = request.getRealPath("upload");
		int size = 1024 * 1024 * 10;
		String fileName = ""; // 업로드 된 파일 이름(중복처리 된 파일 이름)
		String orgFileName = ""; // 원본 파일 이름
		
		MultipartRequest multi = null;
		
		try{
			multi = new MultipartRequest(request, path, size, "UTF-8", new DefaultFileRenamePolicy());
			
			//전송한 전체 파일 이름들을 가져옴
			Enumeration files = multi.getFileNames();
			//시스템 상의 파일 이름을 가져옴
			String str = (String)files.nextElement();
			//중복 처리된 파일 이름을 가져온것
			fileName = (multi.getFilesystemName(str)==null?"없음":multi.getFilesystemName(str));
			//원본 파일의 이름을 가져옴
			orgFileName = multi.getOriginalFileName(str);		
			
			String id = multi.getParameter("id");
			String title = multi.getParameter("title");
			String content = multi.getParameter("content");
			if (fileName.equalsIgnoreCase("없음")) {
				AnswerBoard_DTO dto = new AnswerBoard_DTO(0, id, title, content);
				boolean isc = aDao.insertBoard(dto);
				if(isc) {
					response.sendRedirect("/Final_AnswerBoard_Login/boardList.do?pageNo=1");
				}else {
					response.sendRedirect("/Final_AnswerBoard_Login/error.jsp");
				}
			}else {
				AnswerBoard_DTO dto = new AnswerBoard_DTO(0, id, title, content);
				dto.setFilename(fileName);
				dto.setOrgfile(orgFileName);
				boolean isc = aDao.insertBoardFile(dto);
				if(isc) {
					response.sendRedirect("/Final_AnswerBoard_Login/boardList.do?pageNo=1");
				}else {
					response.sendRedirect("/Final_AnswerBoard_Login/error.jsp");
				}
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void forwardDispatcher(String url, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		logger.info(url + "로 이동함");
		dispatcher.forward(request, response);
		
	}

}
