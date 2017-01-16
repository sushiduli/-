package com.cdv.nsite.program.rs.impl;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cdv.nsite.program.config.SpringContextUtils;
import com.cdv.nsite.program.model.AppUser;
import com.cdv.nsite.program.rs.SecurityRS;
import com.cdv.nsite.program.services.AppUserServiceRS;
import com.cdv.nsite.program.utils.JsonResult;
import com.cdv.nsite.program.utils.RestException;

@RestController
@ComponentScan
public class SecurityImpl implements SecurityRS{

	
	private final static Logger logger = LoggerFactory.getLogger(SecurityImpl.class);
	
	
	@Autowired
	private AppUserServiceRS _userServive;
	
	@Override
	public JsonResult<AppUser> logon(@RequestBody AppUser user) {
		logger.debug("登录操作.....");
		JsonResult<AppUser>  response = new JsonResult<AppUser>();
		
		UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
		
		Subject subject = SecurityUtils.getSubject();
		
		try {
			subject.login(token);
		} catch (AuthenticationException e) {
			String msg;
			int code;
			if (e instanceof UnknownAccountException) {
				msg = "用户记录不存在!";
				code = -1;
			} else if (e instanceof LockedAccountException) {
				msg = "登录失败，账户被锁定。";
				code = -1;
			} else if (e instanceof IncorrectCredentialsException) {
				msg = "登录失败，密码输入错误。";
				code = -1;
			} else if (e instanceof ExcessiveAttemptsException) {
				msg = "登录失败，您太努力啦。";
				code = -1;
			} else {
				msg = "登录失败，其他错误：" + e.getLocalizedMessage();
				code = -1;
				logger.debug(msg, e);
			}
			throw new RestException(code, msg);
		}
		//验证通过
		if(subject.isAuthenticated()){
			response.setCode(0);
			response.setMessage("登录成功了....");
			//保存session 
			Session session = subject.getSession();
			session.setAttribute("userName", user.getUsername());
			//保存到数据库
			_userServive.saveSession(session);
		}
		return response;
		
		/*AppUser appUser = _userServive.getUsers(user);
		if(appUser == null){
			response.setCode(-1);
			response.setMessage("用户不存在");
		}else{
			if(appUser.getPassword().equals(user.getPassword())){
				response.setCode(0);
				response.setMessage("登录成功");
			}else{
				response.setCode(-1);
				response.setMessage("密码错误......");
			}
		}
		*/
	}

	@Override
	public void logoff() {
		logger.debug("登出操作......");;
		Subject subject = SecurityUtils.getSubject();
		if (subject.isAuthenticated()) {
			subject.logout();
		}
	}
	

	@Override
	public JsonResult<String> getSessionCount() {
		JsonResult<String> result = new JsonResult<String>();

		result.setCode(0);
		result.setMessage("请求成功");
		result.setResult(SpringContextUtils.getSessionCount()+"");
		
		return result;
	}

	@Override
	public Session getCurrentSession() {
		Session session = null;
		try {
			session = SecurityUtils.getSubject().getSession(false);
		} catch (Throwable e) {
			//logger.error("获取当前session失败："+e.getMessage(),e);
			throw new RestException(-1, "获取当前session失败");
		}
		return session;
	}

}
