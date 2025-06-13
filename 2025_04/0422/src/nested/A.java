package nested;

/*
 * 클래스 소속의 변수 선언위치에 따라 중첩 내부클래스가 결정됨
 * 		멤버변수 선언 위치 : 인스턴스 변수 선언 위치이면 인스턴스 멤버 내부클래스가 되고,
 * 						정적 변수 선언 위치이면 정적 멤버 내부클래스가 된다.
 * 		메서드 내에 선언된 변수를 지역 변수라고 하며, 지역 변수 선언 위치에 선언된 내부클래스를 로컬 클래스라고 한다.
 */

public class A {
	
	A() {
		System.out.println("A객체가 생성됨");
	}
	
	// 인스턴스 멤버 내부클래스 (자바21 버전에서는 인스턴스 변수(필드)와 정적 변수(필드), 인스턴스 메서드, 정적메서드 모두 올 수 있다.
	// 자바 구버전(20버전 이하)에서는 정적변수와 정적메서드는 올 수 없고 인스턴스 변수와 인스턴스 메서드만 올 수 있다.
	// (단, static final 정적 상수는 예외적으로 허용한다.)
	public class B {
		B() {
			System.out.println("B객체가 생성됨");
		}
		
		int field01;				// 인스턴스 변수 올 수 있음
		static int field02;			// 정적 변수 올 수 있음
		void method01() {}			// 인스턴스 메서드 올 수 있음
		static void method02() {}	// 정적 메서드 올 수 있음
	} // A$B.class
	
	static class C {
		C() {
			System.out.println("C객체가 생성됨");
		}
		int field01;
		static int field02;
		void method01() {}
		static void method02() {}
	} // A$C.class
	
	void method() {
		class D {
			D() {
				System.out.println("D객체가 생성됨");
			}
			
			int field01;
			static int field02;
			void method01() {}
			static void method02() {}
		}
		
		D d = new D();
		d.field01 = 3;
		d.field02 = 10;
		d.method01();
		d.method02();
	} // method
	
}
