
/*
 * 자바의 산술(수학) 연산자 종류
 * +(덧셈), -(뺄셈), *(곱셈), /(나눗셈 : 정수를 나누면 몫만 구함, 실수를 나누면 몫과 나머지를 구함), %(나머지)
 */

public class WeekEx02 {

	public static void main(String[] args) {
		
		int a = 10, b = 3, result = 0;	// 3개의 변수를 한 줄로 선언하고 초기화
		
		result = a + b;
		System.out.printf("%d + %d = %d \n", a, b, result);
		
		result = a - b;
		System.out.println(a + " - " + b + " = " + result);
		
		result = a * b;
		System.out.println(a + " * " + b + " = " + result);
		
		result = a / b;		// 정수 숫자를 나눗셈하면 몫만 구함
		System.out.println(a + " / " + b + " = " + result);
		
		result = a % b;
		System.out.println(a + " % " + b + " = " + result);
		
		
		
	}

}
