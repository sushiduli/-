package com.cdv.login.test.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration()
@ComponentScan(basePackages = { //
		"com.cdv.eo.common.data"
})
public class LoginAutoConfiguration {
}
