/*
 * java.util.function 패키지의 Supplier 계열의 네징 힘수형 인터페이스 특징
 * 		1. 매개값은 없고 리턴값은 있다.
 */

import java.util.function.IntSupplier;

public class SupplierExample {

	public static void main(String[] args) {

		IntSupplier intSupplier = () -> {
			int num = (int)((Math.random() * 6) + 1);
			return num;
		};
		
		int resultNumber = intSupplier.getAsInt();
		System.out.println("임의의 주사위 눈의 수 = " + resultNumber);
		
	}

}
