package com.cdv.eo.common.rs.impl;

import com.cdv.eo.common.rs.ProgramRS;

public class ProgramRSImpl   implements ProgramRS{

	@Override
	public void set(String id, String filed, Object value) {
		if(value instanceof String){
			System.out.println(value);
		}
	}

}
