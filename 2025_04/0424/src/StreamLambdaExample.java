// 스트림과 매개변수 메서드 참조를 활용해서 학생 점수 평균을 실수 타입으로 구하는 예제

import java.util.Arrays;
import java.util.List;

public class StreamLambdaExample {

	public static void main(String[] args) {
		
		List<Student> studentList = Arrays.asList(
				new Student("홍길동", 100),
				new Student("이순신", 96),
				new Student("강감찬", 98)
				);
		
		double avg = studentList.stream()
					 .mapToInt(Student :: getScore)	// 매개변수 메서드 참조를 활용해 학생 점수를 구함
					 .average()			// 평균을 구함
					 .getAsDouble();	// 평균을 실수 숫자로 변경
		
		System.out.println("평균 점수 = " + avg);
		
	}

}
