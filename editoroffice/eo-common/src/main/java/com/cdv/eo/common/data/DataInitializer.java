package com.cdv.eo.common.data;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.cdv.eo.common.utils.Constant;
import com.cdv.nsite.sss.api.lo.SystemApi;
import com.cdv.nsite.sss.model.SystemZ;
import com.cdv.nsite.sss.model.SystemZ.LogoutType;

@Component
public final class DataInitializer implements ApplicationListener<ContextRefreshedEvent>{

	private final static Logger logger = LoggerFactory.getLogger(DataInitializer.class);
	
	// 系统图标
	@Value("${eo.systemLogo:}")
	private String systemLogo;
	
	@Value("${eo.systemName:总编室}")
	private String systemName;
	
	@Value("${eo.secretKey:testeo}")
	private String secretKey;
	
	@Value("${eo.prepare.init-data:true}")
	private boolean needPrepareData;
	
	@Autowired
	private SystemApi _sysApi;
	
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		
		System.setProperty("NSITE_SYS_ID", Constant.SystemZ_ID);
		if (needPrepareData) {
			logger.info("--------------------Initialize Editoroffice Data--------------------");
			this.initData();
			logger.info("--------------------Initialize Editoroffice Data OK--------------------");
		}
	}

	private void initData() {
		
		if(!_sysApi.exists(Constant.SystemZ_ID)){
			SystemZ systemZ = new SystemZ();
			systemZ.setId(Constant.SystemZ_ID);
			systemZ.setName(systemName);
			systemZ.setLogo(systemLogo);
			systemZ.setLogoutType(LogoutType.BACK_CHANNEL);
			systemZ.setSecretKey(secretKey);
			systemZ.setBase(false);
			systemZ.setEnabled(true);
			_sysApi.create(systemZ);
			
			logger.info("插入系统({})成功", systemZ.getName());
		}
	}

}
