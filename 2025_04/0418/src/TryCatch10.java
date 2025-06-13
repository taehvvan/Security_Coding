// for 반복문 안에서 try~catch문 예외 처리

public class TryCatch10 {

	public static void main(String[] args) {

		int number = 100;
		int result = 0;
		for(int i = 1; i <= 10; i++) {
			try {
				result = number / (int)(Math.random() * 10);
				
				System.out.println("result = " + result);
			} catch (ArithmeticException e) {
				System.out.println("0");	// 정수 숫자 난수가 0일 때 예외 발생
			}
		}
		
	}

}
