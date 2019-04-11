package com.happy.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

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

@WebServlet("/UpdateUser")
public class UpdateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logger logger = Logger.getLogger(UpdateUser.class);
    public UpdateUser() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String seq = request.getParameter("seq");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		IUserDao uDao = new UserDaoImpl();
		Map<String, String> map = new HashMap<String, String>();
		map.put("seq", seq);
		map.put("address", address);
		map.put("phone", phone);
		map.put("email", email);
		int n = uDao.updateUserInfo(map);
		UserDto dto = new UserDto();
		dto = uDao.getUserInfo(seq);
		request.setAttribute("dto", dto);
		if(n>0) {
			forwardDispatcher("/WEB-INF/view/userInfo.jsp", request, response);
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
