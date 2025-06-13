// 자바 클래스 상속
//		class 자손클래스 extends 부모클래스 {}

// 자바 클래스는 extends 키워드로 명시적 상속을 받지 않으면 묵시적으로 자바 최상위 클래스인 Object를 상속받음
class Parent01 {
	public void parentPrn() {
		System.out.println("부모클래스 메서드 parentPrn()");
	}
}

class Child01 extends Parent01 {
	public void childPrn() {
		System.out.println("자손클래스 메서드 childPrn()");
	}
}
public class ExtendTest01 {

	public static void main(String[] args) {
		
		Child01 child = new Child01();
		child.parentPrn();	// 부모클래스로부터 상속받아서 메소드 호출
		child.childPrn();	// 자손클래스에 정의된 메소드 호출
		System.out.println("\n====================\n");
		Parent01 p = new Parent01();
		p.parentPrn();	// 부모클래스에서 정의된 메소드 호출
//		p.childPrn();	// 부모클래스 객체로 자손에서 추가된 메소드 호출 불가능

	}

}
