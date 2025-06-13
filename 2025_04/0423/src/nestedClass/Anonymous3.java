package nestedClass;

/* 외부클래스 메서드 내에 익명객체를 구현하고 익명객체 내부에서 외부클래스 메서드 소속의 매개변수나 지역변수를
 * 사용하고자 할 경우 final 속성을 가진다.
 * 자바 8버전부터는 final 속성을 생략 가능하다.
 */

public class Anonymous3 {
	
	private int field;
	
	public void method(int arg01, int arg02) {
		int var01 = 0;
		int var02 = 0;
		
		field = 10;
		
//		arg01 = 10;
//		arg02 = 20;
		
//		var01 = 30;
//		var02 = 40;
		
		Calculatable calc = new Calculatable() {

			@Override
			public int sum() {
				int result = arg01 + arg02 + var01 + var02 + field;
				return result;
			}
			
		};	// 익명객체 구현을 위한 익명클래스 (Anonymous3$1.class)
		
		System.out.println("계산 결과값 = " + calc.sum());
	}
}
