package com.dubbox.service.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

import javax.servlet.ServletContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;



public class SpringDispatcherServlet extends DispatcherServlet {

	private static final long serialVersionUID = 2908157592837054650L;

	private static final Logger logger = LoggerFactory.getLogger(SpringDispatcherServlet.class);

	public static final String WEB_APPLICATION_CONTEXT_ATTRIBUTE = SpringDispatcherServlet.class.getName() + ".CONTEXT";

	private static final String SYS_PPT_APPHOME = "app.home";

	private static final String SYS_PPT_SPRING_CONFIG_LOCATION = "spring.configLocation";

	private String homeDirectory;

	private String logConfigFile;

	private String propertiesFiles;

	public String getHomeDirectory() {
		return homeDirectory;
	}

	public void setHomeDirectory(String homeDirectory) {
		this.homeDirectory = homeDirectory;
	}

	public String getLogConfigFile() {
		return logConfigFile;
	}

	public void setLogConfigFile(String logConfigFile) {
		this.logConfigFile = logConfigFile;
	}

	public String getPropertiesFiles() {
		return propertiesFiles;
	}

	public void setPropertiesFiles(String propertiesFiles) {
		this.propertiesFiles = propertiesFiles;
	}

	@Override
	protected WebApplicationContext initWebApplicationContext() {
		ServletContext servletContext = this.getServletContext();
		String appname = servletContext.getServletContextName();
		String homedir_ppt_name = appname + ".home";
		if (!StringUtils.hasText(this.homeDirectory)) {
			this.homeDirectory = System.getProperty(homedir_ppt_name);
		}
		if (!StringUtils.hasText(this.homeDirectory)) {
			this.homeDirectory = System.getenv(appname + "_home");
		}
		if (!StringUtils.hasText(this.homeDirectory)) {
			this.homeDirectory = ".";
			logger.warn("未找到" + homedir_ppt_name + "，请正确配置，否则系统将无法正常运行！");
			logger.warn("暂时将" + homedir_ppt_name + "的值设置为当前目录！");
		}
		// 强制加入System，以便logback等其他配置使用
		System.setProperty(homedir_ppt_name, this.homeDirectory);
		System.setProperty(SYS_PPT_APPHOME, this.homeDirectory);

		// 日志处理
		System.setProperty("org.apache.cxf.Logger", "org.apache.cxf.common.logging.Slf4jLogger");
		if (!org.slf4j.bridge.SLF4JBridgeHandler.isInstalled()) {
			org.slf4j.bridge.SLF4JBridgeHandler.install();
		}
		File logcf = new File(this.homeDirectory, this.getLogConfigFile());
		logger.info("加载日志配置文件：{}", logcf.getAbsolutePath());
		LoggerConfigurator.config(logcf.getAbsolutePath());

		// 加载配置文件
		for (String str : getPropertiesFileNames()) {
			if (StringUtils.hasLength(str)) {
				loadProperties(this.homeDirectory + "/" + str);
			}
		}

		String loc = System.getProperty(SYS_PPT_SPRING_CONFIG_LOCATION);
		if (loc != null && loc.length() > 0) {
			super.setContextConfigLocation(loc);
		}

		WebApplicationContext wac = super.initWebApplicationContext();
		if (wac != null) {
			servletContext.setAttribute(WEB_APPLICATION_CONTEXT_ATTRIBUTE, wac);
		}

		return wac;
	}

	@Override
	public void destroy() {
		org.slf4j.bridge.SLF4JBridgeHandler.uninstall();
		super.destroy();
	}

	private String[] getPropertiesFileNames() {
		if (StringUtils.hasLength(this.propertiesFiles)) {
			return this.propertiesFiles.split(";");
		} else {
			return new String[] {};
		}
	}

	private void loadProperties(String filename) {
		File file = new File(filename);
		if (!file.exists()) {
			logger.warn("未找到文件：" + filename + "，请正确配置，否则系统将无法正常运行！");
			return;
		}
		logger.info("加载配置文件：{}", file.getAbsolutePath());
		Properties ppts = new Properties();
		try {
			ppts.load(new FileReader(file));
		} catch (FileNotFoundException e) {
			logger.error("未找到文件：" + filename + "，请正确配置，否则系统将无法正常运行！");
		} catch (IOException e) {
			logger.error("加载文件：" + filename + "，请正确配置，否则系统将无法正常运行！");
		}
		// 插入到System.Properties
		for (Enumeration<?> e = ppts.propertyNames(); e.hasMoreElements();) {
			String key = (String) e.nextElement();
			System.setProperty(key, ppts.getProperty(key));
		}
	}
}
