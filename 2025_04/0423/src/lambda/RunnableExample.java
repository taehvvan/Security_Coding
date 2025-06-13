package lambda;

/*
 * 자바 내장 함수형 인터페이스인 Runnable 은 자바 8 버전에서 @FunctionalInterface로 정의되어 있어서
 * 이 인터페이스로 람다식을 구현할 수 있다. 즉, 추상메서드가 딱 하나만 온다 -> run()
 * 결국 멀티스레드를 람다식 문법으로 구현할 수 있다.
 */

public class RunnableExample {

	public static void main(String[] args) {
		
		Runnable run = () -> {
			for(int k = 10; k >= 1; k--) {
				System.out.println(k);
				
				try {
					Thread.sleep(1000);
				} catch(InterruptedException ie) {
					ie.printStackTrace();
				}
			}
		};	// 람다식 익명객체 구현
		
		Thread th = new Thread(run);
		th.start();
		
		
		Thread th2 = new Thread(() -> {
			for(int k = 1; k <= 10; k++) {
				System.out.println(k);
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException ie) {
					ie.printStackTrace();
				}
			}
		});

	}

}
