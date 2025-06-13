// 상속에서 생성자 호출 문제 에러

class Parent06 {
	protected int a = 10;
	protected int b = 20;
	
	public Parent06(int a, int b) {
		super();	// 부모 Object의 기본생성자를 먼저 호출 (생략 가능)
		this.a = a;
		this.b = b;
	}	// 부모의 생성자가 오버로딩되어 더 이상 기본생성자를 묵시적 제공하지 않음
}

class Child06 extends Parent06 {
	protected int c = 30;
	
	public Child06() {
		// super(); 가 생략됨. 부모의 기본생성자를 호출하려다가 컴파일 에러 발생
	}
	
	public void pr() {
		System.out.println("a = " + a + ", b = " + b + ", c = " + c);
	}
}

public class ExtendTest06 {

	public static void main(String[] args) {
		
		Child06 ch06 = new Child06();
		ch06.pr();

	}

}
