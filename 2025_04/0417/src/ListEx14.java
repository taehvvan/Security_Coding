// 제네릭 타입간의 레퍼런스 형변환은 와일드카드 문법을 사용하면 제한적으로 허용한다.

import java.util.ArrayList;

public class ListEx14 {

	public static void main(String[] args) {

		ArrayList<String> cityList = new ArrayList<>();
		
		cityList.add("서울시");
		cityList.add("부산시");
		cityList.add("대전시");
		
		ArrayList<? extends Object> objList;
		/*	<? extends Object> : 제네릭 타입간의 형변환을 허용하는 와일드카드 문법
		 * 		- Object를 상속받은 자손은 제네릭 타입간의 형변환을 제한적으로 허용한다.
		 */
		
		objList = cityList;
		
		for(Object obj : objList) {
			System.out.println(obj);
		}
		
	}

}
