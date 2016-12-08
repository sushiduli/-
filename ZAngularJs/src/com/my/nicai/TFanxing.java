package com.my.nicai;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class TFanxing<T> implements TFx<T> {
	
	Class<T> entityClass;  
	public TFanxing() {
		Type genType = getClass().getGenericSuperclass(); 
		Type[] params = ((ParameterizedType) genType).getActualTypeArguments();  
		entityClass = (Class) params[0];
	}
	
	public T get(){
		try {
			System.out.println(entityClass.getName());
			return entityClass.newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}
