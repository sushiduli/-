package com.lgp.SpringBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class MainApplication implements EmbeddedServletContainerCustomizer{

	@Override
	public void customize(ConfigurableEmbeddedServletContainer container) {
		
		container.setPort(8011);
	}
	
	public static void main(String[] args) {
//		SpringApplication.run(MainApplication.class, args);
		SpringApplication.run(FileController.class, args);
	}
	@RequestMapping("/main")
	public String testPort(){
		
		return "Hello 端口8011......";
	}

}
