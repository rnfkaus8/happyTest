package com.happy.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.happy.dao.AnswerBoard_Impl;
import com.happy.dao.IAnswerBoardDao;
import com.happy.dao.IUserDao;
import com.happy.dao.UserDaoImpl;
import com.happy.dto.AnswerBoard_DTO;

/**
 * Servlet implementation class Write
 */
@WebServlet("/Write")
public class Write extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logger logger = Logger.getLogger(Write.class);
    public Write() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		IAnswerBoardDao aDao = new AnswerBoard_Impl();
		String id = request.getParameter("id");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		System.out.println(id+":"+title+":"+content);
		
		AnswerBoard_DTO aDto = new AnswerBoard_DTO(0,id,title,content);
		boolean isc = aDao.insertBoard(aDto);
		if(isc){
			response.sendRedirect("/Final_AnswerBoard_Login/boardList.do?pageNo=1");
		}else{
			request.setAttribute("url", "./index.jsp");
			request.setAttribute("message", "작성 오류");
			forwardDispatcher("/WEB-INF/view/error.jsp", request, response);
		}
	}
	public void forwardDispatcher(String url, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		logger.info(url + "로 이동함");
		dispatcher.forward(request, response);
	}

}
