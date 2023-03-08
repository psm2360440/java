package bank;

public class Account {
	private String accNo;
	private double balance;
	public Account() {
		this.accNo = MakeAccountNumber.makeAccountNum();
	}
	
	public Account(double balance) throws Exception {
		this();
		if(balance < 0) {
			throw new Exception("ER0001");
		}
		this.balance = balance;
	}
	public Account(String accNo, double balance) throws Exception {
		if(balance < 0) {
			throw new Exception("ER0001");
		}
		this.accNo = accNo;
		this.balance = balance;
	}
	
	public void withdraw (double money) throws Exception {
		if(money <= 0 ) {
			throw new Exception("ER0002");
		}
		if(balance < money) {
			throw new Exception("ER0003");
		}
		balance -= money;
		System.out.println(balance);
	}
	@Override
	public String toString() {
		return "Account [accNo=" + accNo + ", balance=" + balance + "]";
	}
}
