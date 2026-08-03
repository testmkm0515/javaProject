package exception.throwsex;

//예외가 발생할 수 있는 메소드 포함 했음
public class Account {
	private long balance;
	
	public Account() {}
	
	public long getBalance() {
		return balance;
	}
	
	public void deposit(int money) {
		balance += money;
	}
	
	//예외 발생 코드를 가지고 있는 메소드 : 잔고보다 더 많은 출금을 요구할 때(사용자 정의 예외)
	//호출한 곳에서 예외 처리하도록 떠 넘김
	public void withdraw(int money) throws BalanceInsufficientException{
		if(balance < money) {//잔고 부족하면 예외 발생
			//명시적 예외 발생시킴 : 예외에 해당하는 클래스 인스턴스 생성 하면서 생성자 호출 후 throw
			throw new BalanceInsufficientException("잔고 부족 : "+(money-balance)+"모자람");
		}
		balance -= money;
	}
	
}










