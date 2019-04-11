package com.happy.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.happy.dao.IUserDao;
import com.happy.dao.UserDaoImpl;
import com.happy.dto.HappyBoardPagingDto;
import com.happy.dto.UserDto;

@WebServlet("/UserList")
public class UserList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logger logger = Logger.getLogger(UserList.class);
    public UserList() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		IUserDao uDao = new UserDaoImpl();
		String sPageNo = request.getParameter("page");
		int pageNo = 0;
		if(sPageNo == null) {
			pageNo = 1;
		}else {
			pageNo = Integer.parseInt(sPageNo);
		}
		
		String rowSize = request.getParameter("rowSize");
		if(rowSize == null) {
			rowSize = "10";
		}
		HappyBoardPagingDto pg = new HappyBoardPagingDto(Integer.parseInt(rowSize), pageNo, uDao.countEnableUser());
		List<UserDto> lists = uDao.getAllUser(pg);
		request.setAttribute("lists", lists);
		request.setAttribute("pg", pg);
		forwardDispatcher("/WEB-INF/view/userList.jsp", request, response);
	}
	public void forwardDispatcher(String url, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		logger.info(url + "로 이동함");
		dispatcher.forward(request, response);
	}
}
