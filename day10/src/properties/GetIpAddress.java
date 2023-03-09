package properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class GetIpAddress {
	public static String getIpAddress() {
		String ipAddress = "";
		Properties props = new Properties();
		String fileName = "file.txt";

		try (FileInputStream in= new FileInputStream(fileName)){
			props.load(in);
		} catch (IOException e) {
			System.out.println("문제발생!!!");
		}
		ipAddress = props.getProperty("IP_ADDR");
		return ipAddress;
	}
}
