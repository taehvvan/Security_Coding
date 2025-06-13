

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

/* 평가시험 3번문제
 * 
 * PreparedStatement JDBC 쿼리문을 수행하는 API를 사용해서 고객 정보가 저장되게 하는 코드를 작성한다.
 */

public class Customer_Insert01 {
	public static void main(String[] args) {

		String driver = "oracle.jdbc.OracleDriver";	// ojdbc6.jar 에 있는 것으로 oracle.jdbc는 패키지명,
													// OracleDriver는 오라클 jdbc 드라이버
		String url = "jdbc:oracle:thin:@localhost:1521";	// 오라클 접속주소, 1521은 오라클 연결 포트번호
		String user = "night";		// 오라클 사용자명
		String password = "night";	// 사용자 비밀번호
		
		Connection con = null;	// db연결
		PreparedStatement pt = null;	// 쿼리문 수행
		String sql = null;	// 쿼리문 저장 변수
		
		try {
			Class.forName(driver);	// jdbc 드라이버 클래스 로드
			con = DriverManager.getConnection(url, user, password);	// 메서드 인자값으로 오라클 접속주소, 사용자, 비밀번호를 전달하여 연결할 con 생성
			Scanner scan = new Scanner(System.in);
			System.out.println("##### Customer 테이블에 레코드 저장하기 #####");
			System.out.print("고객 이름 >> ");
			String cus_name = scan.nextLine();
			System.out.print("고객 전화번호 >> ");
			String cus_phone = scan.nextLine();
			System.out.print("고객 이메일 >> ");
			String cus_email = scan.nextLine();
			
			sql = "insert into customer (cus_no, cus_name, cus_phone, cus_email, cus_date)"
					+ " values(cus_seq.nextval, ?, ?, ?, sysdate)";
			pt = con.prepareStatement(sql);	// 쿼리문을 미리 컴파일해서 수행할 pt 생성
			pt.setString(1, cus_name);	// 쿼리문의 첫 번째 물음표에 문자열로 고객 이름을 저장
			pt.setString(2, cus_phone);
			pt.setString(3, cus_email);
			
			int re = pt.executeUpdate();	// 저장 쿼리문 수행 후 성공한 레코드 행의 개수를 반환
			
			if(re == 1) {
				System.out.println("고객 정보 저장 성공");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pt != null) pt.close();
				if(con != null) con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
