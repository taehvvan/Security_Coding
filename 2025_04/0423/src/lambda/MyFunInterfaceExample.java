package lambda;

// MyFunInterface 함수형 인터페이스를 활용해서 람다식을 작성한 예제

public class MyFunInterfaceExample {

	public static void main(String[] args) {
		
		MyFunInterface fi;
		
		fi = () -> {
			String result = "method() call 01";
			System.out.println(result);
		};	// 첫 번째 람다식
		fi.method();
		
		fi = () -> System.out.println("method() call 02");
		fi.method();
	}

}
