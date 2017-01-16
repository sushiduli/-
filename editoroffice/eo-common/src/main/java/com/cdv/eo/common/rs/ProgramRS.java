package com.cdv.eo.common.rs;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/eo/program")
public interface ProgramRS {

	@RequestMapping("/set/filed")
	public void set(String id,String filed, Object value);
	
}
