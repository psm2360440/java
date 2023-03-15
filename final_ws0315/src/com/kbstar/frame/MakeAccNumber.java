package com.kbstar.frame;

import java.util.Calendar;
import java.util.Random;

public class MakeAccNumber {
	public static String makeAccNum() {
		String accNo = "";
		Random r=new Random();
		accNo = "015601-04-"+(r.nextInt(999999)+100000); 
		return accNo;
	}

	public static String makeTrNum() {
		int cnt=0;
		String trNum = "";
		Calendar cal = Calendar.getInstance();
		trNum = "" + cal.get(Calendar.YEAR)
		            + (cal.get(Calendar.MONTH)+1)
		            + cal.get(Calendar.DAY_OF_MONTH)
		            + cal.get(Calendar.MILLISECOND)
		            + cnt;
		cnt++;
		return trNum;
	}
}	