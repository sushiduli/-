package com.lgp.SpringBoot;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@ComponentScan
@Configuration
@RestController
@RequestMapping("/file")
public class FileController {

	@RequestMapping("/name")
	public String getFileName(){
		
		return "filename.....";
	}
	
}
