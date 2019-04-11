package com.happy.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import com.happy.dto.HappyBoardPagingDto;
import com.happy.dto.UserDto;
import com.happy.mybatis.SqlSessionFactoryManager;


public class UserDaoImpl implements IUserDao {
	
	private SqlSessionFactory session = SqlSessionFactoryManager.getSqlSessionFactory();
	private Logger logger = Logger.getLogger(UserDaoImpl.class);
	private final String NS = "happy.user.";
	
	@Override
	public List<UserDto> getAllUserStatus(HappyBoardPagingDto pg) {
		logger.info("getAllUserStatus 성공");
		List<UserDto> lists = null;
		SqlSession manager = session.openSession(true);
		lists = manager.selectList(NS+"getAllUserStatus",pg);
		manager.close();
		return lists;
	}

	@Override
	public List<UserDto> getAllUser(HappyBoardPagingDto pg) {
		logger.info("getAllUser");
		List<UserDto> lists = null;
		SqlSession manager = session.openSession(true);
		lists = manager.selectList(NS+"getAllUser",pg);
		manager.close();
		return lists;
	}

	@Override
	public UserDto getLogin(Map<String, String> map) {
		logger.info("getLogin");
		UserDto dto = null;
		SqlSession manager = session.openSession(true);
		dto = manager.selectOne(NS+"getLogin", map);
		manager.close();

		return dto;
	}

	@Override
	public UserDto getUserInfo(String seq) {
		logger.info("getUserInfo");
		UserDto dto = null;
		SqlSession manager = session.openSession(true);
		dto = manager.selectOne(NS+"getUserInfo", seq);
		manager.close();

		return dto;
	}

	@Override
	public int updateAuthUser(Map<String, String> map) {
		logger.info("updateAuthUser");
		int cnt = 0;
		SqlSession manager = session.openSession(true);
		cnt = manager.update(NS+"updateAuthUser", map);
		manager.close();

		return cnt;
	}

	@Override
	public int insertUser(UserDto dto) {
		logger.info("insertUser");
		int cnt = 0;
		SqlSession manager = session.openSession(true);
		cnt = manager.insert(NS+"insertUser", dto);
		manager.close();

		return cnt;
	}

	@Override
	public int updateUserInfo(Map<String, String> map) {
		logger.info("updateUserInfo");
		int cnt = 0;
		SqlSession manager = session.openSession(true);
		cnt = manager.update(NS+"updateUserInfo", map);
		manager.close();

		return cnt;
	}

	@Override
	public int delUser(String seq) {
		logger.info("delUser");
		int cnt = 0;
		SqlSession manager = session.openSession(true);
		cnt = manager.update(NS+"delUser", seq);
		manager.close();

		return cnt;
	}

	@Override
	public String duplicateId(String id) {
		logger.info("duplicateId");
		String str = null;
		SqlSession manager = session.openSession(true);
		str = manager.selectOne(NS+"duplicateId",id);
		manager.close();
		return str;
	}

	@Override
	public int countAllUser() {
		int cnt = 0;
		SqlSession manager = session.openSession(true);
		cnt = manager.selectOne(NS+"countAllUser");
		manager.close();
		return cnt;
	}

	@Override
	public int countEnableUser() {
		int cnt = 0;
		SqlSession manager = session.openSession(true);
		cnt = manager.selectOne(NS+"countEnableUser");
		manager.close();
		return cnt;
	}

}
