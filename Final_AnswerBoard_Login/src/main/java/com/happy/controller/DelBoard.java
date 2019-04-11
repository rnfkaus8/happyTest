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

@WebServlet("/DelBoard")
public class DelBoard extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logger logger = Logger.getLogger(DelBoard.class);
    public DelBoard() {
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String seq = request.getParameter("seq");
		IAnswerBoardDao aDao = new AnswerBoard_Impl();
		boolean isc = aDao.deleteBoardReal(seq);
		if(isc){
			response.sendRedirect("/Final_AnswerBoard_Login/boardList.do");
		}else{
			request.setAttribute("url", "./index.jsp");
			request.setAttribute("message", "삭제 오류");
			String url = "/WEB-INF/error.jsp";
			forwardDispatcher(url, request, response);
		}
	}
	
	public void forwardDispatcher(String url, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		logger.info(url + "로 이동함");
		dispatcher.forward(request, response);
	}
}
