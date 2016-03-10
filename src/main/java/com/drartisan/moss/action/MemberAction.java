package com.drartisan.moss.action;

import com.drartisan.moss.entity.Member;
import com.drartisan.moss.service.MemberService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/member")
public class MemberAction {

	@Autowired 
	private MemberService ms;
	Logger logger = Logger.getLogger(MemberAction.class);
	
	@RequestMapping("/login")
	@ResponseBody
	public Member login(HttpServletRequest request, String username, String password){
		System.out.println(request.getMethod());
		return ms.login(username, password);
	}
	
	
	@RequestMapping("/register")
	@ResponseBody
	public Member register(HttpServletRequest request,String username,String password){		
		if (ms.register(username, password)) {//register
			return ms.login(username, password);
		}else {
			return null;
		}
	}
	

}
