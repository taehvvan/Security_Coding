/*
 * 하나의 try문과 복수개의 catch문이 오는 경우 :
 * catch 블록문에 예외 처리 자손클래스를 먼저 기술하고, 예외 처리 부모클래스는 나중에 기술한다.
 * 이유는 해당 cath 블록문을 순차적으로 찾아서 가장 관련성이 있는 예외처리를 먼저 하기 때문이다.
 */
public class TryCatch04 {

	public static void main(String[] args) {
		
		int a = 10, b01 = 0, b02 = 2, result = 0;
		
		try {
			result = a / b02;
			System.out.println("[1]result = " + result);
			
			result = a / b01;	// 정수 숫자를 0으로 나누어 예외 발생
			System.out.println("[2]result = " + result);	// 문장 수행 안하고 catch문으로 이동
		} catch (ArithmeticException e) {	// 보다 구체적인 자손클래스를 먼저 기술함
			System.out.println("예외 발생 : " + e);
		} catch (Exception e) {				// 부모클래스는 나중에 기술함
			e.printStackTrace();	// 예외 족적을 남김
		}

	}

}
