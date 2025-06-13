/*
 * 메소드 오버로딩과 메소드 오버라이딩의 차이점
 * 		메소드 오버로딩
 * 			- 메소드 오버로딩은 상속과 관련이 없음 
 * 			- 동일한 클래스 내에서 같은 이름의 메소드를 여러 번 중복 정의하는 것
 * 		메소드 오버라이딩
 * 			- 상속이라는 전제 조건이 있어야 적용됨
 * 			- 상속 관계에서 부모의 메소드 이름, 전달인자 개수와 타입, 리턴타입이 모두 동일한 원형을
 * 			  자손에서 상속받은 상태에서 자손에 맞게 { } 내의 본문 실행문장을 변경하여 수행하는 것
 * 
 * 생성자는 메소드의 일종이기 때문에 상속과 관련 없는 생성자 오버로딩 문법은 존재한다
 * 하지만 생성자는 상속되지 않기 때문에 생성자 오버라이딩 문법은 존재하지 않는다
 */

class Parent03 {
	public void p03() {
		System.out.println("부모의 메서드 p03()");
	}
}

class Child03 extends Parent03 {
	
	@Override
	public void p03() {
		super.p03();
		System.out.println("오버라이딩한 메소드");
	}
	
	public void ch03() {
		System.out.println("자손에서 정의한 메소드 ch03()");
	}
}

public class ExtendTest03 {

	public static void main(String[] args) {
		
		Child03 ch03 = new Child03();
		ch03.p03();
		ch03.ch03();
		System.out.println("\n=====================\n");
		
		Parent03 p = new Parent03();
		p.p03();

	}

}
