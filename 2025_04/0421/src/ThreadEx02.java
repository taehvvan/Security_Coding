// main() 메서드도 단일 스레드이다. 이 스레드 이름을 출력하는 예제

public class ThreadEx02 {

	public static void main(String[] args) {

		System.out.println(Thread.currentThread().getName());	// 현재 실행 중인 스레드 이름 반환
		
		
	}

}
