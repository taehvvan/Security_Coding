import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class FromIntRangeExample {

	static int sum;
	public static void main(String[] args) {

        IntStream stream = IntStream.rangeClosed(1, 100);
        
        stream.forEach(k -> sum += k);
        
        System.out.println("1부터 100까지의 누적합: " + sum);
        
        System.out.println("\n=======================\n");
        
        List<Integer> numList = new ArrayList<>();
        
        for(int i = 0; i < 10; i++) {
        	numList.add((int)(Math.random()*10)+1);
        }
        
        System.out.println(numList);
        
        System.out.println("\n=======================\n");
        
        sum = 0;
        
        for(int i : numList) {
        	sum += i;
        }
        
        System.out.println("numList 원소값의 누적합 : " + sum);
	}
}
