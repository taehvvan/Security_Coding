package lambda;

// MyFunInterface3 함수형 인터페이스를 사용해서 람다식을 구현한 예제

public class MyFunInterfaceExample3 {

	public static void main(String[] args) {

		MyFunInterface3 fi;
		
		fi = (a, b) -> {
			int result = a + b;
			return result;
		};
		
		System.out.println("7 + 7 = " + fi.method(7, 7));
		
		fi = (a, b) -> a * b;	// return과 { }를 생략함
		System.out.println("7 * 7 = " + fi.method(7, 7));
		
		fi = (x, y) -> sum(x, y);
		System.out.println("10 - 5 = " + fi.method(10, 5));
	}
	
	public static int sum(int a, int b) {
		return a - b;
	}

}
