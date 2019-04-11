package com.happy.main;

import com.happy.dao.AnswerBoard_Impl;
import com.happy.dao.IAnswerBoardDao;
import com.happy.dto.AnswerBoard_DTO;
import com.happy.mybatis.SqlSessionFactoryManager;

public class Main {
	public static void main(String[] args) {
		SqlSessionFactoryManager.getSqlSessionFactory();
//		IAnswerBoardDao dao = new AnswerBoard_Impl();
//		for (int i = 3; i <= 58; i++) {
//			AnswerBoard_DTO dto = new AnswerBoard_DTO(0, "HAPPY", ""+i, ""+i);
//			dao.insertBoard(dto);
//		}
	}
}
