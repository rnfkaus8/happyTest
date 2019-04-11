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

@WebServlet("/UpdateAuth")
public class UpdateAuth extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logger logger = Logger.getLogger(UpdateAuth.class);
    public UpdateAuth() {
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		IUserDao uDao = new UserDaoImpl();
		String seq = request.getParameter("seq");
		String auth = request.getParameter("role");
		System.out.println(seq+":"+auth);
		Map<String, String> map = new HashMap<String, String>();
		map.put("seq", seq);
		map.put("auth", auth);
		int n = uDao.updateAuthUser(map);
		if(n>0){
			response.sendRedirect("/Final_AnswerBoard_Login/userList.do?page=1");
		}else{
			response.sendRedirect("/Final_AnswerBoard_Login/updateAuthForm.do?seq="+seq);
		}
	}
	
	public void forwardDispatcher(String url, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		logger.info(url + "로 이동함");
		dispatcher.forward(request, response);
	}

}
