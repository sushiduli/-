package com.my.nicai;

import java.io.File;
import java.lang.reflect.Type;
import java.util.Date;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


public class BuCai {

	public static void main(String[] args) {
		System.out.println(System.currentTimeMillis());
		String data = new Date(Long.parseLong("1472191128304")).toString();
		System.out.println(data);
		
		File file = new File("./config/");
		System.out.println(file.getAbsolutePath());
		
		System.out.println(System.getenv("path"));
		BuCai bc = new BuCai();
		Person person1 = bc.new Person();
		Person person = (Person)getCByJson("{'name':'123','gender':'0'}",person1);
		System.out.println(person.gender);
	}
	
	class Person{
		String name;
		String gender;
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T getCByJson(String json, T t){
		Gson gson = GsonBuilderUtil.create();
		if(t instanceof List){
			Type type = new TypeToken<T>(){}.getType();
			t = gson.fromJson(json,type);
		}else{
			t = (T) gson.fromJson(json,t.getClass());
		}
		return t;
		
	}
	
	
	
}
