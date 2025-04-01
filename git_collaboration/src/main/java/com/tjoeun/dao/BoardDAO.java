package com.tjoeun.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tjoeun.dto.ContentDTO;

@Repository
public class BoardDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public void addContentInfo(ContentDTO writeContentDTO) {
		sqlSessionTemplate.insert("board.addContentInfo", writeContentDTO);
	}

	public String getBoardInfoName(int board_info_idx) {
		String board_info_name = sqlSessionTemplate.selectOne("board.getBoardInfoName",board_info_idx);
		return board_info_name;
	}
	
	public List<ContentDTO> getContentList(int board_info_idx, RowBounds rowBounds){
		List<ContentDTO> contentDTOList = sqlSessionTemplate.selectList("board.getContentList", board_info_idx, rowBounds);
		return contentDTOList;
	}
	
	public ContentDTO getContentInfo(int content_idx) {
		ContentDTO contentDTO = sqlSessionTemplate.selectOne("board.getContentInfo", content_idx);
		return contentDTO;		
	}
	
	public void modifyContentInfo(ContentDTO modifyContentDTO) {
		sqlSessionTemplate.selectOne("board.modifyContentInfo", modifyContentDTO);
	}
	
	public void deleteContentInfo(int content_idx) {
		sqlSessionTemplate.delete("board.deleteContentInfo", content_idx);
	}
	
	public int getContentCount(int content_board_idx) {
		int contentPageCount = sqlSessionTemplate.selectOne("board.getContentCount", content_board_idx);
		return contentPageCount;
	}
}




