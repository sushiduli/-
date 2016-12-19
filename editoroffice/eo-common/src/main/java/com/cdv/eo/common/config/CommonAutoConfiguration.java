package com.cdv.eo.common.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration()
@ComponentScan(basePackages = { //
		"com.cdv.eo.common.data", //
		"com.cdv.eo.common.rs", //
		"com.cdv.eo.common.service" //
})
public class CommonAutoConfiguration {
}
