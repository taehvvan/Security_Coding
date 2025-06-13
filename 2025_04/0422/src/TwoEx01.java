/*
 * 출금 작업과 같은 특정 작업이 이루어질 때에는 synchronized 키워드로 동기화를 처리해야 하는데
 * 이를 하지 않아서 출금 후 은행 잔액이 음의 정수가 나오는 예제
 */

class Account {
	private int balance = 1000;		// 계좌 잔액
	
	// 잔액조회
	public int getBalance() {
		return balance;
	}
	
	// 동기화를 하지 않은 출금작업
	public void withdraw(int money) {
		if(balance >= money) {
			try {
				Thread.sleep(1000);
			} catch(InterruptedException ie) {}
			balance -= money;
		} // if
	} // withdraw()
} // Account

class RunnableEx01 implements Runnable
{
	Account acc = new Account();	// 계좌 객체 생성
	
	@Override
	public void run() {
		while(acc.getBalance() > 0) {
			int money = (int)(Math.random()*3+1)*100;
			acc.withdraw(money);
			System.out.println("출금 후 잔액 = " + acc.getBalance());
		}
	} // 스레드 문장 구현
	
}

public class TwoEx01 {

	public static void main(String[] args) {
		
		Runnable r = new RunnableEx01();	// 업캐스팅
		new Thread(r).start();
		new Thread(r).start();

	}

}
