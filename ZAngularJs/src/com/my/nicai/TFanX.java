package com.my.nicai;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class TFanX extends TFanxing<Person>{

	public static void main(String[] args) throws ParseException {
		long time = new java.util.Date().getTime();
		long ds = Long.parseLong("1475764651905");
		
		System.out.println(time/Double.parseDouble(ds+""));
		
		 BigDecimal bd = new BigDecimal(time/Double.parseDouble(ds+""));  
	      System.out.println(bd.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());  
		
		DecimalFormat df = new DecimalFormat("#.00");   
		
		System.out.println(df.format(time/Double.parseDouble(ds+"")));
		System.out.println(new java.text.DecimalFormat("#.00").format(0.005926));
		
		Date startTime = new SimpleDateFormat("yyyy-MM-dd").parse("2016-09-12");
		Date endTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS").parse("2016-09-12 00:00:00 999");
		
		int day = (int)((endTime.getTime()-startTime.getTime())/(1000 * 86400));
		System.out.println(endTime.getTime()-startTime.getTime());
		System.out.println(day);
		
		//当前是时间也要变成GMT+8的，为了计算
		Date  now = new Date();
		SimpleDateFormat formate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
		String today = formate.format(now);
		formate.setTimeZone(TimeZone.getTimeZone("CMT+8"));
		Date nowGmt = formate.parse(today);
		
		System.out.println("当前时间："+today+" ===加了8时区后："+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS").format(nowGmt));
		System.out.println("当前时间："+now.getTime()+" ===加了8时区后："+nowGmt.getTime());
		
	}
	
}
