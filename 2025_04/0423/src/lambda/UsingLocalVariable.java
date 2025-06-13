package lambda;

/*
 * MyFunInterface5 인터페이스를 메서드 내에 람다식 익명객체로 구현해본다.
 * 람다식 익명객체 내에서 메서드 소속 매개변수나 지역변수를 사용할 경우 final 상수로 인식한다.
 */

public class UsingLocalVariable {
	
	void method(int arg) {	// arg는 final 속성을 가진 상수로 인식함
		int localVar = 40;	// localVar도 final 상수로 인식
		
//		arg = 31;		// final 상수라서 수정 못 함
//		localVar = 41;	// final 상수라서 수정 못 함
		
		MyFunInterface5 fi = () -> {
			System.out.println("arg = " + arg);
			System.out.println("localVar = " + localVar);
		};
		fi.method();
	}

}
