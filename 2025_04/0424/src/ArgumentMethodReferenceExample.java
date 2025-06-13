// 매개변수 메서드 참조에 관한 예제

import java.util.function.ToIntBiFunction;

public class ArgumentMethodReferenceExample {

	public static void main(String[] args) {
		
		/*
		 * ToIntBiFunction 함수 인터페이스 특징
		 * 		1. 이 함수형 인터페이스에 정의된 추상메서드 int applyAsInt(T t, U u)는
		 * 		   2개의 인자값을 전달받아서 int타입으로 결과값을 변환 후 반환한다.
		 */
		
		ToIntBiFunction<String, String> function;
		
		// 람다식
		// String 클래스 하위의 compareToIgnoreCase() 인스턴스 내장메서드는
		// 두 문자열이 대소문자와 상관없잇 동일한 알파벳으로 구성되어 있는지 비교한다.
		// 사전순으로 a가 먼저 오면 음수, 동일하면 0, 나중에 오면 양수를 반환한다.
		function = (a, b) -> a.compareToIgnoreCase(b);
		print(function.applyAsInt("java21", "JAVA21"));
		
		// a매개변수 메서드 참조로 변환
		function = String :: compareToIgnoreCase;
		print(function.applyAsInt("Java8", "java8"));
	}
	
	public static void print(int order) {
		if (order < 0) {
			System.out.println("사전순으로 먼저 나옵니다.");
		} else if (order == 0) {
			System.out.println("동일한 문자열입니다.");
		} else {
			System.out.println("사전순으로 나중에 나옵니다.");
		} // if else if
	} // print

}
