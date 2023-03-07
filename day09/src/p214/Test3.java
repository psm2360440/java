package p214;

import java.io.IOException;
import java.io.InputStreamReader;

public class Test3 {

	public static void main(String[] args) {
		double a = 0;
		double result = 10 / a;
		System.out.println(result);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		InputStreamReader ir = new InputStreamReader(System.in);
		System.out.println("Input Character...");
		int b = 0;
		try {
			b = ir.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(b);
		System.out.println("End...");
	}
}