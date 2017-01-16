package com.cdv.nsite.program.rs;

import org.apache.shiro.session.Session;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cdv.nsite.program.model.AppUser;
import com.cdv.nsite.program.utils.JsonResult;

@RequestMapping("/security")
public interface SecurityRS {
	
	@RequestMapping(value="/logon",method=RequestMethod.POST)
	public JsonResult<AppUser> logon(@RequestBody AppUser user);
	
	@RequestMapping(value="/logoff",method = RequestMethod.GET)
	public void logoff();
	
	@RequestMapping(value="/getOnline",method = RequestMethod.GET )
	public JsonResult<String> getSessionCount();
	
	@RequestMapping(value="/getCurrentSession",method= RequestMethod.GET)
	public Session getCurrentSession();
	
}
