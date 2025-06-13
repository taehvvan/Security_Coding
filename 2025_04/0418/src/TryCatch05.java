/*
 * try~catch문에서 예외가 발생하든 발생하지 않든 무조건 마지막에 수행해야 하는 문장을 넣을 때는 finally 사용
 */
public class TryCatch05 {

	public static void main(String[] args) {
		
		int a = 10, b01 = 0, b02 = 2, result = 0;
		
		try {
			result = a / b02;
			System.out.println("1 : result = " + result);
			
			result = a / b01;		// 예외 발생, catch문으로 이동
			System.out.println("2 : result = " + result);	// 수행 안함
			
			result = a / b02;
			System.out.println("3 : result = " + result);	// 수행 안함
		} catch (ArithmeticException ae) {
			ae.printStackTrace();
		} catch (Exception e) {
			System.out.println("예외 처리 : " + e);
		} finally {
			System.out.println("예외와 상관없이 무조건 마지막에 실행");
		}

	}

}
