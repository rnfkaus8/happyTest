package com.happy.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import com.happy.dto.AnswerBoard_DTO;
import com.happy.dto.HappyBoardPagingDto;
import com.happy.mybatis.SqlSessionFactoryManager;


public class AnswerBoard_Impl implements IAnswerBoardDao {
	
	private SqlSessionFactory session = SqlSessionFactoryManager.getSqlSessionFactory();
	private final Logger log = Logger.getLogger(AnswerBoard_Impl.class);
	private final String NS = "com.answerboard.";
	
	@Override
	public List<AnswerBoard_DTO> selectAllBoard() {
		log.info("selectAllBoard");
		List<AnswerBoard_DTO> lists = null;
		SqlSession manager = session.openSession(true);
		lists = manager.selectList(NS+"selectAllBoard");
		manager.close();
		return lists;
	}

	@Override
	public AnswerBoard_DTO selectDetailBoard(String seq) {
		log.info("selectDetailBoard");
		AnswerBoard_DTO dto = null;
		SqlSession manager = session.openSession(true);
		dto = manager.selectOne(NS+"selectdetailBoard",seq);
		manager.close();
		return dto;
	}

	@Override
	public boolean reply(AnswerBoard_DTO dto) {
		log.info("reply");
//		boolean isc = false;
		SqlSession manager = session.openSession(false);
		int u = manager.update(NS+"replyUpdate", dto);
		int i = manager.insert(NS+"replyInsert", dto);
		manager.commit();
		manager.close();
		return ((u+i)>0)?true:false;
	}

	@Override
	public boolean modifyBoard(AnswerBoard_DTO dto) {
		log.info("modifyBoard");
//		boolean isc = false;
		SqlSession manager = session.openSession(true);
		int m = manager.update(NS+"modifyBoard", dto);
		manager.close();
		return m>0?true:false;
	}

	@Override
	public boolean deleteBoard(String seq) {
		log.info("deleteBoard");
//		boolean isc = false;
		SqlSession manager = session.openSession(true);
		int d = manager.update(NS+"deleteBoard", seq);
		manager.close();
		return d>0?true:false;
	}

	@Override
	public boolean insertBoard(AnswerBoard_DTO dto) {
		log.info("insertBoard");
//		boolean isc = false;
		SqlSession manager = session.openSession(true);
		int i = manager.insert(NS+"insertBoard", dto);
		manager.close();
		return i>0?true:false;
	}

	@Override
	public boolean readBoard(String seq) {
		log.info("readBoard");
//		boolean isc = false;
		SqlSession manager = session.openSession(true);
		int c = manager.update(NS+"readBoard", seq);
		manager.close();
		return c>0?true:false;
	}

	@Override
	public boolean deleteBoardReal(String seq) {
		log.info("deleteBoardReal");
//		boolean isc = false;
		SqlSession manager = session.openSession(true);
		int d = manager.update(NS+"deleteBoardReal", seq);
		manager.close();
		return d>0?true:false;
	}

	@Override
	public boolean multiDelete(String[] seqs) {
		log.info("multiDelete");
//		boolean isc = false;
		SqlSession manager = session.openSession(false);
		int cnt = 0;
		for (int i = 0; i < seqs.length; i++) {
			cnt += manager.update(NS+"multiDelete", seqs[i]);
		}
		manager.commit();
		manager.close();
		return cnt>0?true:false;
	}

	@Override
	public int countPage() {
		int cnt = 0;
		SqlSession manager = session.openSession(true);
		cnt = manager.selectOne("countPage");
		manager.close();
		
		return cnt;
	}

	@Override
	public List<AnswerBoard_DTO> selectPaging(HappyBoardPagingDto pg) {
		List<AnswerBoard_DTO> lists = null;
		SqlSession manager = session.openSession(true);
		lists = manager.selectList(NS+"selectPaging", pg);
		manager.close();
		return lists;
	}

	@Override
	public boolean insertBoardFile(AnswerBoard_DTO dto) {
		log.info("insertBoardFile");
//		boolean isc = false;
		SqlSession manager = session.openSession(true);
		int i = manager.insert(NS+"insertBoardFile", dto);
		manager.close();
		return i>0?true:false;
	}

}

