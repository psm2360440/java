package ws0307;
//사용자정의 예외
public class BelowZeroException extends Exception {
	public BelowZeroException() {
	}
	public BelowZeroException(String msgcode) {
		super(msgcode);
	}
}