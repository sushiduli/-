package com.dubbox.service;

public class DemoServiceImpl implements DemoService{

	@Override
	public String greet(String name) {
		return "HI, "+name;
	}

}
