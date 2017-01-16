package com.cdv.nsite.program.services.impl;

import java.util.List;
import java.util.Map;

import org.apache.shiro.session.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RestController;

import com.cdv.nsite.program.model.AppUser;
import com.cdv.nsite.program.services.AppUserServiceRS;

@RestController
@ComponentScan
public class AppUserServiceImpl implements AppUserServiceRS{

	
	private final static Logger logger = LoggerFactory.getLogger(AppUserServiceImpl.class);
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public boolean isExistUser(AppUser user) {
		
		  String sql = "select * from appuser where username = '"+user.getUsername()+"'";
	      List<Map<String, Object>> list =  jdbcTemplate.queryForList(sql);
	      return null !=list && list.size()>0 ?true:false;
	}

	@Override
	public AppUser getUsers(AppUser user) {
		String sql = "select id,username,password,sex,telphone from appuser where username = '" + user.getUsername() + "'";
		List<AppUser> userList = null;
		AppUser appUser = null;
		try {
			userList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<AppUser>(AppUser.class));
			appUser = userList != null?userList.get(0):null;
		} catch (Throwable e) {
			logger.error(e.getMessage(),e);
		}
		return appUser;
	}

	@Override
	public List<AppUser> getUsers(String ids) {
		List<AppUser> userList = null;
		String sql = "select * from appuser where id in(" + ids + ")";
		userList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<AppUser>(AppUser.class));
		return userList;
	}
	
	@Override
	public AppUser getUserByName(String username) {
		AppUser user = new AppUser();
		user.setUsername(username);
		return getUsers(user);
	}

	@Override
	public void saveSession(Session session) {
		logger.debug("保存Session操作....未实现");
	}
}
