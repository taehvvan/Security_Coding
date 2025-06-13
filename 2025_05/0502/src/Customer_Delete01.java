/*
 * 스캐너로 먼저 고객번호를 입력받아서 오라클로부터 검색한 다음 해당 고객 번호가 있는 경우
 * 고객 번호를 기준으로 삭제되게 한다. 고객 번호가 없으면 유효성 검증 메시지를 출력한다.
 * 
 * 쿼리문을 수행할 때는 보안이 좋은 PreparedStatement JDBC API를 사용한다.
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import net.daum.dao.CustomerDAOImpl;
import net.daum.dto.CustomerDTO;

public class Customer_Delete01 {
	public static void main(String[] args) {

		String driver = "oracle.jdbc.OracleDriver";	// ojdbc6.jar 에 있는 것으로 oracle.jdbc는 패키지명,
		// OracleDriver는 오라클 jdbc 드라이버
		String url = "jdbc:oracle:thin:@localhost:1521";	// 오라클 접속주소, 1521은 오라클 연결 포트번호
		String user = "night";		// 오라클 사용자명
		String password = "night";	// 사용자 비밀번호
		
		Connection con = null;	// db연결
		PreparedStatement pstmt = null;	// 쿼리문 수행
		ResultSet rs = null;	// 검색 결과 레코드를 저장
		String sql = null;	// 쿼리문 저장 변수
		
		CustomerDAOImpl cdao = new CustomerDAOImpl();
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			Scanner scan = new Scanner(System.in);
			System.out.println(">>> 고객번호 삭제 <<<");
			System.out.print("고객번호 입력 >> ");
			int cus_no = Integer.parseInt(scan.nextLine());
			
			CustomerDTO cusNo = cdao.getCus_No(cus_no);
			if(cusNo != null) {
				sql = "delete from customer where cus_no = ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, cus_no);
				
				int re = pstmt.executeUpdate();
				
				if(re == 1) {
					System.out.println("고객정보 삭제 성공");
				}
			} else {
				System.out.println("고객번호가 검색되지 않아서 삭제할 수 없습니다.");
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
}
