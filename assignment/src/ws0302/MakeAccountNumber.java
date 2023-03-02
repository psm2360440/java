package ws0302;

import java.util.Calendar;

public class MakeAccountNumber {
	public static String makeAccountNum() {
		String accNum = "";
		Calendar cal = Calendar.getInstance();
		accNum = "" + cal.get(Calendar.YEAR)
					+ (cal.get(Calendar.MONTH)+1)
					+cal.get(Calendar.DAY_OF_MONTH)
					+cal.get(Calendar.MILLISECOND);
		return accNum;
	}
}