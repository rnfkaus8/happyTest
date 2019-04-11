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
import com.happy.dto.AnswerBoard_DTO;

@WebServlet("/Reply")
public class Reply extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logger logger = Logger.getLogger(Reply.class); 
    public Reply() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		IAnswerBoardDao aDao = new AnswerBoard_Impl();
		String seq = request.getParameter("seq");
		String id = request.getParameter("id");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		System.out.println(seq+":"+id+":"+title+":"+content);
		AnswerBoard_DTO aDto = new AnswerBoard_DTO(Integer.parseInt(seq),id,title,content);
		boolean isc = aDao.reply(aDto);
		if(isc){
			response.sendRedirect("/Final_AnswerBoard_Login/boardList.do?pageNo=1");
		}else{
			request.setAttribute("url", "./index.jsp");
			request.setAttribute("message", "답글 오류");
			forwardDispatcher("/WEB-INF/view/error.jsp", request, response);
		}
	}
	public void forwardDispatcher(String url, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		logger.info(url + "로 이동함");
		dispatcher.forward(request, response);
	}
}
