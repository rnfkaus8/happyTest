package com.happy.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.happy.dao.IUserDao;
import com.happy.dao.UserDaoImpl;

@WebServlet("/DelUser")
public class DelUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logger logger = Logger.getLogger(DelUser.class);
    public DelUser() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IUserDao uDao = new UserDaoImpl();
		String seq = request.getParameter("seq");
		int n = uDao.delUser(seq);
		if(n>0) {
			response.sendRedirect("/Final_AnswerBoard_Login/index.jsp");
		}else {
			response.sendRedirect("/Final_AnswerBoard_Login/index.jsp");
		}
	}
	
	public void forwardDispatcher(String url, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		logger.info(url + "로 이동함");
		dispatcher.forward(request, response);
	}
}
