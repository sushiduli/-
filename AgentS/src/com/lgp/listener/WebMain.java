package com.lgp.listener;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.bridge.SLF4JBridgeHandler;

import com.lgp.agent.TheAgent;
import com.lgp.db.CommonDao;

public class WebMain implements ServletContextListener{

	protected static final String logPath_param = "logConfigFile";
	
	protected static final String propPath_param = "propertiesFiles";
	
	protected static final String h2DbPath_param = "h2DbPath";
	
	protected static final String SYS_APP_APPHOME = "app.home";
	
	protected static final Logger logger = LoggerFactory.getLogger(WebMain.class);
	
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		logger.info("����رա�������");
		SLF4JBridgeHandler.uninstall();
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
	
		ServletContext context = arg0.getServletContext();
		initialize(context);
	}

	private  void initialize(ServletContext context) {
		
		String logPath = context.getInitParameter(logPath_param);  
		
		String propPath = context.getInitParameter(propPath_param);

		String filePath = this.getClass().getResource("/").getFile();
		
	    System.out.println("��־��������·���ļ���=="+filePath+logPath);
		
		if(propPath!=null){

			String[] paths = propPath.split(";");
			for (String propath : paths) {
				loadProperties(filePath+propath);
			}
		}
		
		if(!SLF4JBridgeHandler.isInstalled()){
			SLF4JBridgeHandler.install();
		}
		LoggerConfigurator.config(filePath+logPath);
		
		//����H2
		String h2DbPath = context.getInitParameter(h2DbPath_param);
		System.setProperty("h2DbPath", filePath+h2DbPath);
		CommonDao.CreateTable();
		
				ScheduledExecutorService service = Executors.newScheduledThreadPool(10);
				long initialDelay =10;
				service.scheduleAtFixedRate(new TheAgent(),initialDelay, Long.valueOf(10),
						TimeUnit.SECONDS);
	}
	
	private void loadProperties(String filename) {
		File file = new File(filename);
		if (!file.exists()) {
			logger.warn("δ�ҵ��ļ���" + filename + "������ȷ���ã�����ϵͳ���޷��������У�");
			return;
		}
		logger.info("���������ļ���{}", file.getAbsolutePath());
		Properties ppts = new Properties();
		try {
			ppts.load(new FileReader(file));
		} catch (FileNotFoundException e) {
			logger.error("δ�ҵ��ļ���" + filename + "������ȷ���ã�����ϵͳ���޷��������У�");
		} catch (IOException e) {
			logger.error("�����ļ���" + filename + "������ȷ���ã�����ϵͳ���޷��������У�");
		}
		// ���뵽System.Properties
		for (Enumeration<?> e = ppts.propertyNames(); e.hasMoreElements();) {
			String key = (String) e.nextElement();
			System.setProperty(key, ppts.getProperty(key));
		}
	}
	
	
}
