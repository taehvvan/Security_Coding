/*
 * try~catch 문으로 예외 처리
 * 
 * 		try {
 * 			정상구문이 수행되다가 예외가 발생하면 아래 문장을 수행하지 않고 catch 블록문으로 이동하여 예외 처리
 * 		} catch (예외처리 클래스 매개변수) {
 * 			예외 처리;
 * 		}
 */
public class TryCatch03 {

	public static void main(String[] args) {
		
		int a = 10, b01 = 0, b02 = 2, c = 10;
		System.out.println("try 구문 실행 전 c값 = " + c);
		
		try {
			c = a / b02;
			System.out.println("(1)c = " + c);
			
			c = a / b01;	// 예외가 발생하고 아래문장 수행 안함. catch 블록으로 이동
			System.out.println("(2)c = " + c);
			
			c = a / b02;
			System.out.println("(3)c = " + c);
		} catch (Exception e) {		// Exception은 예외처리 부모 클래스
			System.out.println("예외 발생 : " + e);	// java.lang.ArithmeticException: / by zero
													// 정수 숫자를 0으로 나눴을 때 발생하는 예외 에러
		}
		System.out.println("try 구문 실행 후 c값 = " + c);

	}

}
