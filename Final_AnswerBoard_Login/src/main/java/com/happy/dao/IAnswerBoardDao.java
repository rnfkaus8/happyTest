package com.happy.dao;

import java.util.List;
import java.util.Map;

import com.happy.dto.AnswerBoard_DTO;
import com.happy.dto.HappyBoardPagingDto;



public interface IAnswerBoardDao {
	
	public List<AnswerBoard_DTO> selectAllBoard();

	public AnswerBoard_DTO selectDetailBoard(String seq);

	public boolean reply(AnswerBoard_DTO dto);
	
	public boolean modifyBoard(AnswerBoard_DTO dto);

	public boolean deleteBoard(String seq);

	public boolean insertBoard(AnswerBoard_DTO dto);
	public boolean insertBoardFile(AnswerBoard_DTO dto);

	public boolean readBoard(String seq);

	public boolean deleteBoardReal(String seq);

	public boolean multiDelete(String[] seqs);
	
	public int countPage();
	
	public List<AnswerBoard_DTO> selectPaging(HappyBoardPagingDto pg);
}
