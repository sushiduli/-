package com.my.nicai;

import java.math.BigDecimal;
import java.util.Date;

public class Person {

	public String name;
	public String gender;

	private Date birthday;
	
	public static void main(String[] args) {
/*		Person person = new Person();
		person.setBirthday(new Date());
		person.setName("0");
		person.setGender("12");
		
		String json = GsonBuilderUtil.create().toJson(person, Person.class);
		System.out.println(json);
		
		String ss = "{name:'0','gender':'12','birthday':1474431235442}";
		Person son = GsonBuilderUtil.create().fromJson(json, Person.class);
		System.out.println(son.getBirthday());*/
		
		int days = 100;
		for (int i = 0; i < 10; i++) {
			days= days+20;
			BigDecimal base = new BigDecimal((long)days*8*60*60*1000);
			System.out.println(days+"==="+base);
		}
		
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	
	
}
