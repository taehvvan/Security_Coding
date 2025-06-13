/*
 * 먼저 스캐너로 고객번호를 입력받아서 오라클 DB로부터 고객번호를 검색해서 있는 경우
 * 수정할 고객 이름, 고객 폰번호, 고객 이메일을 입력받아서 고객번호를 기준으로 수정
 * 해당 고객번호가 없으면 유효성 검증(Validation) 메시지를 띄운다.
 * 쿼리문을 수행하는 Statement API를 사용
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Customer_Edit01 {
	public static void main(String[] args) {
		
		String driver = "oracle.jdbc.OracleDriver";	// ojdbc6.jar 에 있는 것으로 oracle.jdbc는 패키지명,
		// OracleDriver는 오라클 jdbc 드라이버
		String url = "jdbc:oracle:thin:@localhost:1521";	// 오라클 접속주소, 1521은 오라클 연결 포트번호
		String user = "night";		// 오라클 사용자명
		String password = "night";	// 사용자 비밀번호
		
		Connection con = null;	// db연결
		Statement stmt = null;	// 쿼리문 수행
		ResultSet rs = null;	// 검색 결과 레코드를 저장
		String sql = null;	// 쿼리문 저장 변수
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			stmt = con.createStatement();
			Scanner scan = new Scanner(System.in);
			System.out.println(">>> 고객정보 수정 <<<");
			System.out.print("기준이 되는 고객번호 입력 >> ");
			int cus_no = Integer.parseInt(scan.nextLine());	// 고객번호를 문자열로 입력받아 정수로 변환
			sql = "select cus_no from customer where cus_no = " + cus_no;
			rs = stmt.executeQuery(sql);	// 검색 쿼리문 수행 후 결과 레코드를 rs에 저장
			
			if(rs.next()) {	// 검색된 레코드가 하나이면 if문으로 처리
				System.out.print("수정할 고객이름 입력 >> ");
				String cus_name = scan.nextLine();
				System.out.print("수정할 고객폰번호 입력 >> ");
				String cus_phone = scan.nextLine();
				System.out.print("수정할 고객이메일 입력 >> ");
				String cus_email = scan.nextLine();
				
				sql = "update customer set cus_name = '" + cus_name + 
						"', cus_phone = '" + cus_phone + "', cus_email = '" + cus_email + 
						"' where cus_no = " + cus_no;
				
				int re = stmt.executeUpdate(sql);	// 수정 쿼리문 수행 후 성공한 레코드 행의 개수를 반환
				
				if(re == 1) {
					System.out.println("고객정보 수정 성공");
				}
			} else {
				System.out.println("검색된 고객번호가 없습니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(con != null) con.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}

	}

}
