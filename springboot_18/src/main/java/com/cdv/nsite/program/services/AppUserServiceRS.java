package com.cdv.nsite.program.services;

import java.util.List;

import org.apache.shiro.session.Session;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cdv.nsite.program.model.AppUser;

@Service
@RequestMapping("/security")
public interface AppUserServiceRS {
	
	@RequestMapping(value="/user/isExist",method = RequestMethod.POST)
	public boolean isExistUser(@RequestBody AppUser user);
	
	@RequestMapping(value="/user/get",method = RequestMethod.POST)
	public AppUser getUsers(@RequestBody AppUser user);
	
	@RequestMapping(value="/user/byIds",method = RequestMethod.GET)
	public List<AppUser> getUsers(@RequestParam String ids);
	
	@RequestMapping(value="/user/getByName",method = RequestMethod.GET)
	public AppUser getUserByName(String username);

	public void saveSession(Session session);
}
