// 멀티스레드 스케줄링 메서드 중에서 wait(), notify() 메서드에 관한 실습 예제

import java.util.ArrayList;

class Table {
	String[] dishNames = {"donut", "donut", "burger"};	// 음식 재료
	final int MAX_FOOD = 6;
	private ArrayList<String> dishes = new ArrayList<>();
	
	// 동기화된 음식 추가
	public synchronized void add(String dish) {
		while(dishes.size() >= MAX_FOOD) {
			String name = Thread.currentThread().getName();	// 현재 실행 중인 스레드 이름 반환
			System.out.println(name + " is waiting");
			
			try {
				wait();
				Thread.sleep(500);
			} catch(InterruptedException ie) {}
		} // while
		dishes.add(dish);	// 음식 추가
		notify();			// 기다리고 있는 요리사 스레드를 깨움
		System.out.println("Dishes : " + dishes.toString());	// 추가한 음식 목록 출력
	} // add()
	
	public void remove(String dishName) {
		synchronized (this) {
			String name = Thread.currentThread().getName();
			
			while(dishes.size() == 0) {		// 테이블에 음식이 없는 경우
				System.out.println(name + " is waiting");
				
				try {
					wait();
					Thread.sleep(500);
				} catch(InterruptedException ie) {}
			} // while
			
			while(true) {
				for(int i = 0; i < dishes.size(); i++) {
					if(dishName.equals(dishes.get(i))) {
						dishes.remove(i);	// 음식을 제거 => 식사를 했다는 의미
						notify();	// 요리사 스레드를 깨운다
						return;	// 종료
					} // if
				} // for
				
				try {
					System.out.println(name + " is waiting");
					wait();		// 원하는 음식이 없으면 손님스레드를 기다리게 함
					Thread.sleep(500);
				} catch(InterruptedException ie) {}
			} // while
		}
	} // remove()
	
	public int dishNum() {
		return dishNames.length;	// 음식 재료 개수 반환 => 3
	}
} // Table class

class Customer implements Runnable {
	
	private Table table;
	private String food;
	
	public Customer(Table table, String food) {
		this.table = table;
		this.food = food;
	}
	
	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(100);
			} catch(InterruptedException ie) {}
			String name = Thread.currentThread().getName();
			
			table.remove(food);		// 테이블로부터 음식을 식사해서 제거
			System.out.println(name + " ate a " + food);
		} // while
	} // run()
} // Customer class

// 요리사 스레드
class Cook implements Runnable {
	
	private Table table;
	
	public Cook(Table table) {
		this.table = table;
	}

	@Override
	public void run() {
		while(true) {
			int idx = (int)(Math.random()*table.dishNum());	// 0, 1, 2 중 하나의 난수 발생
			table.add(table.dishNames[idx]);	// 테이블에 음식 추가
			
			try {
				Thread.sleep(10);
			} catch(InterruptedException ie) {}
		} // while
	} // run()
} // Cook class

public class TwoEx02 {

	public static void main(String[] args) throws Exception {
		
		Table table = new Table();
		
		new Thread(new Cook(table), "COOK01").start();		// 요리사 스레드 시작
		new Thread(new Customer(table, "donut"), "CUST01").start();	// 손님 스레드 시작
		new Thread(new Customer(table, "burger"), "CUST02").start();
		
		Thread.sleep(2000);		// 2초 뒤에 메인스레드 종료
		System.exit(0);		// 정상적인 종료 방법

	}

}
