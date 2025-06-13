
public class Ex07_04 {

	public static void main(String[] args) {

		for(int i = 1; i <= 9; i++) {
			for(int k = 2; k <= 9; k++) {
				System.out.printf("%d * %d = %d\t", k, i, k * i);
			}
			System.out.println();
		}
	}

}
