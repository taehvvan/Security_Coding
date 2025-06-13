// 제네릭 타입간의 레퍼런스간의 형변환은 허용되지 않는다.

import java.util.ArrayList;

public class ListEx13 {

	public static void main(String[] args) {

		ArrayList<String> list = new ArrayList<>();
		list.add("apple");
		list.add("banana");
		list.add("orange");
		
		ArrayList<Object> objList;
		objList = list;		// <String> -> <Object> 제네릭 형변환 불가능
		
		for(Object obj : objList) {
			System.out.println(obj);
		}
		
	}

}
