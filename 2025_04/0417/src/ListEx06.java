/*
 * java.util 패키지의 클랙션 클래스 Stack의 특징
 * 		1. jdk 1.0에서 추가되었다.
 * 		2. 입구와 출구가 같기 때문에 가장 먼저 입력된 데이터가 가장 나중에 나오는 구조이다.
 * 		   (FILO : First Input Last Output)
 * 		3. 가장 나중에 입력된 데이터가 가장 먼저 나오는 구조이다.
 * 		   (LIFO : Last Input First Output)
 */

import java.util.Stack;

public class ListEx06 {

	public static void main(String[] args) {
		
		Stack myStack = new Stack();
		
		myStack.push("1-java");		// push() : 스택의 맨 위에 원소값을 추가
		myStack.push("2-oracle");
		myStack.push("3-html");
		
		while(!myStack.isEmpty()) {		// 현재 스택이 비어있지 않으면 참
			System.out.println(myStack.pop());	// pop() : 스택의 맨 위에서 값을 제거하면서 반환
		}

	}

}
