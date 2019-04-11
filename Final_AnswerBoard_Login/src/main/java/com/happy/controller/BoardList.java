package com.happy.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.happy.dto.HappyBoardPagingDto;

@WebServlet("/BoardList")
public class BoardList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logger logger = Logger.getLogger(BoardList.class);
    public BoardList() {
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		System.out.println("전체조회 페이지 이동");
		IAnswerBoardDao aDao = new AnswerBoard_Impl();
		
		String sPageNo = request.getParameter("pageNo");
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
		List<AnswerBoard_DTO> allList = aDao.selectAllBoard();
		HappyBoardPagingDto pg = new HappyBoardPagingDto(Integer.parseInt(rowSize), pageNo, allList.size());
		
		List<AnswerBoard_DTO> aLists = aDao.selectPaging(pg);
		
		request.setAttribute("aLists", aLists);
		request.setAttribute("pg", pg);
		System.out.println(aLists);
		System.out.println(pg);
		String url = "/WEB-INF/view/boardList.jsp";
		forwardDispatcher(url, request, response);
	}
	
	public void forwardDispatcher(String url, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		logger.info(url + "로 이동함");
		dispatcher.forward(request, response);
	}
}
