package com.drartisan.moss.service;

import java.util.Calendar;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drartisan.moss.dao.BaseDao;
import com.drartisan.moss.entity.Member;

@Service
public class MemberService {

	@Autowired
	private BaseDao<Member> dao;
	@Autowired
	private UtilService us;
	Logger logger = Logger.getLogger(MemberService.class);
	
	
	
	/**
	 * login
	 * @param username
	 * @param password
	 * @return
	 */
	public Member login(String username,String password) {
		Member member = dao.get(Member.class, "username", username);
		if (member!=null) {
			if (member.getPassword().equals(us.getPasswordMD5(username, password))) {
				
				Calendar calendar=Calendar.getInstance();   
				calendar.setTime(new Date()); 
				calendar.set(Calendar.DAY_OF_MONTH,calendar.get(Calendar.DAY_OF_MONTH)+10);//让日期加1  
				
				//设置客户端登陆有效时间
				member.setExpired(calendar.getTime());
				dao.update(member);
				return member;
			}
		}
		
		return null;
	}
	
	/**
	 * register
	 * @param username
	 * @param password
	 * @return
	 */
	public boolean register(String username,String password) {
		Member member = new Member();
		member.setUsername(username);
		member.setPassword(us.getPasswordMD5(username, password));
		
		try {
			dao.save(member);
			logger.info(username+" register successful!");
			return true;
		} catch (Exception e) {
			logger.error(username+" register failure for the error of " + e.toString());
			return false;
		}
	}
	
}
