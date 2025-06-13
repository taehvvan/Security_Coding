// 생성자는 상속되지 않는다.

class Parent05 extends Object {
	protected int x = 10;
	protected int y = 20;
	
	public Parent05() {
		super();
		System.out.println("부모 Parent05 기본생성자");
	}
}

class Child05 extends Parent05 {
	protected int z = 30;
	
	public Child05() {
//		super();	// super()가 생략됨
		System.out.println("자손 Child05 기본생성자");
	}
	
	public void print() {
		System.out.println("x = " + x + ", y = " + y + ", z = " + z);
	}
}

public class ExtendTest05 {

	public static void main(String[] args) {
		
		Child05 ch05 = new Child05();
		ch05.print();

	}

}
