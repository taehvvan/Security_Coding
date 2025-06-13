// 사용자 정의 예외 클래스 생성

class UserException extends Exception {		// 예외 처리 부모클래스 Exception을 상속받음
	public UserException(String msg) {	// 생성자 오버로딩
		super(msg);		// 부모 클래스 생성자 호출
	}
}

public class TryCatch09 {

	public static void main(String[] args) {

		try {
			int a = -11;
			if (a <= 0) {
				throw new UserException("양수가 아닙니다.");
			}
		} catch (UserException e) {
			System.out.println(e.getMessage());		// 예외 에러 메시지 출력
		}
		
	}

}
