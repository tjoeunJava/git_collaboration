package com.tjoeun.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tjoeun.dto.UserDTO;

@Repository
public class UserDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	public String checkUserId(String user_id) {
		String user_name = sqlSessionTemplate.selectOne("user.checkUserId", user_id);
		return user_name;
	}
	
	public void addUserInfo(UserDTO joinUserDTO) {
		sqlSessionTemplate.insert("user.addUserInfo", joinUserDTO);
	}
	
	public UserDTO getLoginUserInfo(UserDTO loginProcUserDTO) {
		UserDTO loginProcUserDTO2 = sqlSessionTemplate.selectOne("user.getLoginUserInfo", loginProcUserDTO);
		return loginProcUserDTO2;
	}
	
	public UserDTO getModifyUserInfo(int user_idx){
		UserDTO modifyUserDTO = sqlSessionTemplate.selectOne("user.getModifyUserInfo", user_idx);
		return modifyUserDTO;		
  }	
	
	public void modifyUserInfo(UserDTO modifyUserDTO) {
		sqlSessionTemplate.update("user.modifyUserInfo", modifyUserDTO);
	}
	
}




