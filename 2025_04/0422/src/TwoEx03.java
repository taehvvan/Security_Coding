// 자바 21에서 추가된 가상 스레드 생성법 3가지
public class TwoEx03 {

	public static void main(String[] args) {

		// 자바21 : 첫 번째 방법
		Thread.startVirtualThread(() -> {
			System.out.println("첫 번째 가상 스레드 생성 방법");
		});
		
		// 자바21 : 두 번째 방법
		Thread.ofVirtual().start(() -> {
			System.out.println("두 번째 가상 스레드 생성 방법");
		});
		
		// 자바21 : 세 번째 방법 ( 스레드 이름을 설정 )
		Thread virtualThread03 = Thread.ofVirtual().name("downloadThread").start(() -> {
			System.out.println("스레드 이름을 설정한 세 번째 가상 스레드 생성 방법");
		});
		
		System.out.println("virtualThread03 스레드 이름 : " + virtualThread03.getName());
	}

}
