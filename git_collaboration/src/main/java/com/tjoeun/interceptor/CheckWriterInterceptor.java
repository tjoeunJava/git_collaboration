package com.tjoeun.interceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.servlet.HandlerInterceptor;

import com.tjoeun.dto.ContentDTO;
import com.tjoeun.dto.UserDTO;
import com.tjoeun.service.BoardService;

public class CheckWriterInterceptor implements HandlerInterceptor{
	
	@Resource(name="loginUserDTO")
	@Lazy
	private UserDTO loginUserDTO;
	
	@Autowired
	private BoardService boardService;
	
  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
  	
  	String strContentIdx = request.getParameter("content_idx");  	
  	int contentIdx = Integer.parseInt(strContentIdx);
  	ContentDTO currentContentDTO =  boardService.getContentInfo(contentIdx);
  	
  	if(currentContentDTO.getContent_writer_idx() != loginUserDTO.getUser_idx()) {
  		String contextPath = request.getContextPath();
  		response.sendRedirect(currentContentDTO + "/board/not_writer");
  		return false;
  	}
  	
  	return true;
  }
}





