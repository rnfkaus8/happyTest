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
import com.happy.dto.UserDto;

@WebServlet("/UpdateForm")
public class UpdateForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logger logger = Logger.getLogger(UpdateForm.class);
    public UpdateForm() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IUserDao uDao = new UserDaoImpl();
		String seq = request.getParameter("seq");
		System.out.println();
		System.out.println(seq);
		UserDto dto = uDao.getUserInfo(seq);
		System.out.println(dto);
		request.setAttribute("dto", dto);
		forwardDispatcher("/WEB-INF/view/updateUserInfoForm.jsp", request, response);
	}
	
	public void forwardDispatcher(String url, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		logger.info(url + "로 이동함");
		dispatcher.forward(request, response);
	}

}
