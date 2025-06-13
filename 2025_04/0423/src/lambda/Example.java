package lambda;

/* 자바 10버전에서는 var 키워드로 변수 선언 시 타입을 명시적으로 지정하지 않고 컴파일러가 타입을 추론하게 해준다.
 * 이 키워드를 사용해서 생성자나 메서드 내의 지역변수를 선언할 때에도 사용할 수 있다.
 */
public class Example {

	// 생성자 내에서 var 키워드 사용
	public Example() {
		var localVariable = "Hello! Java!";		// String 타입으로 추론
		System.out.println(localVariable);
	}
	
	// 메서드 내에서 var 키워드 사용
	public void printMessage() {
		var message = "Hello! Java 10";		// String 타입으로 추론
		var number = 77;	// int 타입으로 추론
		
		System.out.println(message);
		System.out.println(number);
	}
	public static void main(String[] args) {

		Example example = new Example();	// new Example()에 의해서 기본생성자 호출
		example.printMessage();
		
	}

}
