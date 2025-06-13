/*
 * 1. throw : 인위적 예외를 발생시킬 때 사용
 * 		사용 예시) throw new 예외클래스 생성자;
 * 
 * 2. throws : 발생된 예외를 자신이 직접 처리하는 것이 아니라 자신을 호출한 곳으로 떠넘기면서 예외 처리
 * 		사용 예시) public 리턴타입 메서드명(매개변수 .. ) throws 예외처리클래스 
 * 				{
 * 					실행문장;
 * 				}
 */
public class TryCatch08 {

	static void exp(int a) throws NullPointerException {
		if(a == 0) {
			throw new NullPointerException();	// 인위적 예외 발생
		}
	}
	
	public static void main(String[] args) {

		try {
			System.out.println("예외 발생하기 전");
			exp(0);		// 예외 발생
			System.out.println("메서드 호출 후 예외 발생");
		} catch (NullPointerException ne) {
			ne.printStackTrace();
		}
		
	}

}
