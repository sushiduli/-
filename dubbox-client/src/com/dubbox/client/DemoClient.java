package com.dubbox.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dubbox.service.DemoService;

@RestController
@RequestMapping(value="/api")
public class DemoClient {
	
	@Autowired
	DemoService _demoService;
	
	@RequestMapping(value="/greet")
	public String greet(@RequestParam("name") String name){
		System.out.println(_demoService.greet(name));
		return _demoService.greet(name);
	}

}
