package com.cdv.nsite.program;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.context.annotation.Configuration;


@Configuration
@EnableAutoConfiguration(exclude={JpaRepositoriesAutoConfiguration.class})
@SpringBootApplication
public class Application implements EmbeddedServletContainerCustomizer{
	
	private final static Logger logger = LoggerFactory.getLogger(Application.class);
	
	@Value("${displayname:pm}")
	String displayname;
	
    public static void main( String[] args )
    {
    	SpringApplication.run(Application.class, args);
    }

	@Override
	public void customize(ConfigurableEmbeddedServletContainer container) {
		logger.info("工程名称："+displayname);
		container.setContextPath("/"+displayname);
	}
}
