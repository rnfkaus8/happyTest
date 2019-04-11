package com.happy.dao;

import java.util.List;
import java.util.Map;

import com.happy.dto.HappyBoardPagingDto;
import com.happy.dto.UserDto;

public interface IUserDao {
	public List<UserDto> getAllUserStatus(HappyBoardPagingDto pg);
	public List<UserDto> getAllUser(HappyBoardPagingDto pg);
	public UserDto getLogin(Map<String, String> map);
	public UserDto getUserInfo(String seq);
	public int updateAuthUser(Map<String, String> map);
	public int insertUser(UserDto dto);
	public int updateUserInfo(Map<String, String> map);
	public int delUser(String seq);
	public String duplicateId(String id);
	public int countAllUser();
	public int countEnableUser();

}
