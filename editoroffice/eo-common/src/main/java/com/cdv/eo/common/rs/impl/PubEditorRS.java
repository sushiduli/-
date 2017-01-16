package com.cdv.eo.common.rs.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cdv.nsite.common.util.RestfulUtils;

@Controller
@RequestMapping("/api/pub/eo")
public class PubEditorRS {
	private final List<Class<?>> clazzs = Arrays.asList( //
			com.cdv.eo.common.rs.ProgramRS.class //
	);

	@RequestMapping( //
			value = "/js/angular/proxyService.js", //
			method = { RequestMethod.GET }, //
			produces = { "*/*", "text/*", "application/*", "application/x-javascript; charset=UTF-8" }, //
			consumes = { "*/*", "text/*", "application/*", "application/x-javascript; charset=UTF-8" })
	public String pubAnguarProxyServices( //
			@RequestParam(required = false, value = "contextPath", defaultValue = ".") String restContextPath, //
			@RequestParam(required = false, value = "appName", defaultValue = "app") String angularAppName, //
			@RequestParam(required = false, value = "name", defaultValue = "eo_proxyService") String angularServiceModuleName) {
		return RestfulUtils.generateAngularJS("", restContextPath, angularAppName, angularServiceModuleName, clazzs);
	}

	@RequestMapping( //
			value = "/js/require/angular/proxyService.js", //
			method = { RequestMethod.GET }, //
			produces = { "*/*", "text/*", "application/*", "application/x-javascript; charset=UTF-8" }, //
			consumes = { "*/*", "text/*", "application/*", "application/x-javascript; charset=UTF-8" })
	public String pubRequireAnguarProxyServices( //
			@RequestParam(required = false, value = "angularRequireFrom", defaultValue = "angular") String angularRequireFrom, //
			@RequestParam(required = false, value = "appRequireFrom", defaultValue = "app.js") String angularAppRequireFrom, //
			@RequestParam(required = false, value = "contextPath", defaultValue = ".") String restContextPath, //
			@RequestParam(required = false, value = "appName", defaultValue = "app") String angularAppName, //
			@RequestParam(required = false, value = "name", defaultValue = "eo_proxyService") String angularServiceModuleName) {

		return RestfulUtils.generateRequireAngularJS(angularRequireFrom, angularAppRequireFrom, restContextPath,
				angularAppName, angularServiceModuleName, clazzs);
	}
}
