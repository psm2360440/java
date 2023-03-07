package ws0307;

import java.util.Calendar;
//accNo생성
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