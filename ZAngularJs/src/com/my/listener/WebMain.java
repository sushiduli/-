package com.my.listener;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;


public class WebMain implements ServletContextListener {
	protected static final String INIT_PARAM_HOMEDIR = "homeDirectory";

	protected static final String INIT_PARAM_LOGCONFIGFILE = "logConfigFile";

	protected static final String INIT_PARAM_PROPERTIESFILES = "propertiesFiles";

	protected static final String SYS_PPT_APPHOME = "app.home";


	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		//org.slf4j.bridge.SLF4JBridgeHandler.uninstall();
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		ServletContext sc = arg0.getServletContext();
		initialize(sc);
	}

	protected String getLogbackConfigFileName() {
		return null;
	}

	protected String[] getPropertiesFileNames() {
		return new String[] {};
	}

	public String getLogbackConfigFileName(ServletContext servletContext) {
		String cfn = servletContext.getInitParameter(INIT_PARAM_LOGCONFIGFILE);
		if (StringUtils.hasLength(cfn)) {
			return cfn;
		} else {
			return this.getLogbackConfigFileName();
		}
	}

	private String[] getPropertiesFileNames(ServletContext servletContext) {
		String ppfs = servletContext
				.getInitParameter(INIT_PARAM_PROPERTIESFILES);
		if (StringUtils.hasLength(ppfs)) {
			return ppfs.split(";");
		} else {
			return this.getPropertiesFileNames();
		}
	}

	protected void initialize(ServletContext servletContext) {
		String appname = servletContext.getServletContextName();
		String homedir_ppt_name = appname + ".home";
		String homedir = servletContext.getInitParameter(INIT_PARAM_HOMEDIR);
		if (!StringUtils.hasText(homedir)) {
			homedir = System.getProperty(homedir_ppt_name);
		}
		if (!StringUtils.hasText(homedir)) {
			homedir = System.getenv(appname + "_home");
		}
		if (!StringUtils.hasText(homedir)) {
			homedir = ".";
		}
		// 强制加入System，以便logback等其他配置使用
		System.setProperty(homedir_ppt_name, homedir);
		System.setProperty(SYS_PPT_APPHOME, homedir);


		// 加载配置文件
		for (String str : getPropertiesFileNames(servletContext)) {
			if (StringUtils.hasLength(str)) {
				loadProperties(homedir + "/" + str);
			}
		}


		try {
			ZooKeeperUtils.init();
		} catch (Exception e) {
		}
		// Scanner Schedule
		/*ScheduledExecutorService service = Executors.newScheduledThreadPool(10);
		long initialDelay =30;
		service.scheduleAtFixedRate(new File(), initialDelay, Long.valueOf(System.getProperty(cycle)),
				TimeUnit.SECONDS);*/
	}

	private void loadProperties(String filename) {
		File file = new File(filename);
		if (!file.exists()) {
			return;
		}
		Properties ppts = new Properties();
		try {
			ppts.load(new FileReader(file));
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
		}
		// 插入到System.Properties
		for (Enumeration<?> e = ppts.propertyNames(); e.hasMoreElements();) {
			String key = (String) e.nextElement();
			System.setProperty(key, ppts.getProperty(key));
		}
	}
}
