package com.lgp.agent;

import com.lgp.db.CommonDao;

public class TheAgent implements Runnable{

	@Override
	public void run() {

		CommonDao.getTableData();
		
	}

}
