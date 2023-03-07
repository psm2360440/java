package ws0307;

public class Account {
	private String accNo;
	private String name;
	private String accHolder;
	private double balance;
	// Constructor - 음수 예외 상황 //
	// 계좌 정보 조회
	// 잔액 조회
	// 입금 - 음수 예외 상황
	// 출금 - 잔액 부족 예외 상황, 음수 예외 상황
	
	//default생성자
	public Account() {
		super();
		this.accNo = MakeAccountNumber.makeAccountNum();
		this.name = "KB종합통장";
	}
	//생성자(accHolder, balance)와 입금금액 예외
	public Account(String accHolder, double balance) throws BelowZeroException {
		this();
		if (balance < 0) {
			throw new BelowZeroException("입금금액Error");
		}
		this.accHolder = accHolder;
		this.balance = balance;
	}
	
	//getter&setter
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAccNo() {
		return accNo;
	}
	public String getAccHolder() {
		return accHolder;
	}
	public double getBalance() {
		return balance;
	}

	//인출 예외(음수 금액 + 잔액보다 큰 인출금액)
	public void withdarw(double money) throws BelowZeroException {
		if (money < 0) {
			throw new BelowZeroException("출금금액Error");
		} else if (money > balance) {
			throw new BelowZeroException("잔액Error");
		}
		this.balance -= money;
	}
	
	//입금 예외(음수 금액)
	public void deposit(double money) throws BelowZeroException {
		if (money < 0) {
			throw new BelowZeroException("입금금액Error");
		}
		this.balance += money;
	}
	
	@Override
	public String toString() {
		return "Account [accNo=" + accNo + ", name=" + name + ", accHolder=" + accHolder + ", balance=" + balance + "]";
	}
}