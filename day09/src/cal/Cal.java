package cal;

public class Cal {
	public static double div(int a, int b) throws Exception {
		double result = 0.0;
		try {
			result = a / b;
		} catch (ArithmeticException EA) {
			throw EA;
		}
		return result;
	}

	public static double div(double a, double b) throws InfinityException {
		double result = 0.0;
		if( b == 0.0) {
			throw new InfinityException("SM01");
		}
		result = a / b;
		return result;
	}
}
