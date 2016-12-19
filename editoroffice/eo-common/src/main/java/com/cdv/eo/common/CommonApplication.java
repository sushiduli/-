package com.cdv.eo.common;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

import com.cdv.nsite.common.CommonProperties;

@SpringBootApplication
@ImportResource(locations = { "classpath:com/cdv/eo/common/dubbox.xml" })
public class CommonApplication {

	public static void main(String[] args) throws IOException {
		System.setProperty("dubbo.shutdown.hook", "true");
		String loc = CommonProperties.loadProperties2System(System.getProperty("spring.config.location"));
		System.getProperties().setProperty("application.version", CommonProperties.getVersion(CommonApplication.class));
		System.getProperties().setProperty("app.home", loc + "/..");

		SpringApplication.run(CommonApplication.class, args);
	}
}
