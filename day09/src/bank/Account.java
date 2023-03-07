package bank;

public class Account {
	private String accNo;
	private String name;
	private String accHolder;
	private double balance;
	
	//Constructor - 음수 예외 상황 //
	
	// 계좌 정보 조회
	
	// 잔액 조회
	
	// 입금 - 음수 예외 상황
	
	// 출금 - 잔액 부족 예외 상황, 음수 예외 상황 
	
	public Account() {
		super();
		this.accNo = MakeAccountNumber.makeAccountNum();
		this.name = "KB종합통장";
	}

	public Account(String accHolder, double balance) throws BelowZeroException {
		this();
		if( balance < 0) {
			throw new BelowZeroException("입금금액Error");
		}
		this.accHolder = accHolder;
		this.balance = balance;
	}

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
	
	public void withdarw(double money) throws BelowZeroException {
		if(money < 0 ) {
			throw new BelowZeroException("출금금액Error");
		}else if( money > balance ) {
			throw new BelowZeroException("잔액Error");
		}
		this.balance-=money;
	}
	

	
	public void deposit(double money) throws BelowZeroException {
		if(money < 0) {
			throw new BelowZeroException ("입금금액Error");
		}
		this.balance+=money;
	}


	@Override
	public String toString() {
		return "Account [accNo=" + accNo + ", name=" + name + ", accHolder=" + accHolder + ", balance=" + balance + "]";
	}
	

}
