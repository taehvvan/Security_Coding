package lambda;

// MyFunInterface2 함수형 인터페이스를 활용해서 람다식을 구현한 예제

public class MyFunInterfaceExample2 {

	public static void main(String[] args) {
		
		MyFunInterface2 fi;
		
		fi = (var data) -> {
			int result = data * 7;
			System.out.println("7 x 7 = " + result);
		};
		fi.method(7);
		
		fi = x -> System.out.println("7 + 7 = " + (x + 7));
		fi.method(7);

	}

}
