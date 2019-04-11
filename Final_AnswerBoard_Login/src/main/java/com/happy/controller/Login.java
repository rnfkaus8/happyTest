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
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.happy.dao.AnswerBoard_Impl;
import com.happy.dao.IAnswerBoardDao;
import com.happy.dao.IUserDao;
import com.happy.dao.UserDaoImpl;
import com.happy.dto.AnswerBoard_DTO;
import com.happy.dto.UserDto;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logger logger = Logger.getLogger(Login.class);
	public Login() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		IAnswerBoardDao aDao = new AnswerBoard_Impl();
		IUserDao uDao = new UserDaoImpl();
		
		HttpSession session = request.getSession();

		String id = request.getParameter("id");
		String password = request.getParameter("pw");
		System.out.println(id+":"+password);
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		map.put("password", password);

		//MyBatis는 객체를 반환해 주기 때문에
		//결과가 없을 경우 null을 반환한다.
		//				System.out.println(uDao.getLogin(map));
		UserDto lDto = uDao.getLogin(map);
		if(lDto != null && lDto.getEnable().equalsIgnoreCase("Y")){
			session.setAttribute("lDto", lDto);
//				 			session.setMaxInactiveInterval(10*60); //10분동안 활동이 없으면 session을 자동으로 삭제
			
			System.out.println("밖" + lDto.getAuth());
			// 페이지 이동 ADMIN, USER
			if(lDto.getAuth().equalsIgnoreCase("ADMIN")){
				forwardDispatcher("/WEB-INF/view/adminMain.jsp", request, response);
			}else if(lDto.getAuth().equalsIgnoreCase("USER")){
				System.out.println("유저" + lDto.getAuth());
				response.sendRedirect("/Final_AnswerBoard_Login/boardList.do?pageNo=1");
//				forwardDispatcher("/WEB-INF/view/boardList.jsp", request, response);
			}
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
