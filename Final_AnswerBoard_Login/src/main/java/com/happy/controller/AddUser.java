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

@WebServlet("/AddUser")
public class AddUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logger logger = Logger.getLogger(AddUser.class);
    public AddUser() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		IUserDao uDao = new UserDaoImpl();
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		
		System.out.println(id+":"+password+":"+name+":"+address+":"+phone+":"+email);
		
		UserDto dto = new UserDto();
		dto.setId(id);
		dto.setPassword(password);
		dto.setName(name);
		dto.setAddress(address);
		dto.setPhone(phone);
		dto.setEmail(email);
		
		int n = uDao.insertUser(dto);
		if(n>0){
			response.sendRedirect("./index.jsp");
		}else{
			response.sendRedirect("./WEB-INF/view/error.jsp");
		}
	}
	
	public void forwardDispatcher(String url, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		logger.info(url + "로 이동함");
		dispatcher.forward(request, response);
	}

}
