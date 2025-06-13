/*
 *  스캐너로 고객번호를 입력받아서 오라클로부터 검색을 한 다음 있을 경우
 *  저장 프로시저를 실행하게 하고 없으면 유효성 검증 메시지를 띄운다.
 */

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

import net.daum.dao.CustomerDAOImpl;
import net.daum.dto.CustomerDTO;

public class CustomerProExample {
	public static void main(String[] args) {

		String driver = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";	// 오라클 접속주소
		String user = "night";
		String pwd = "night";
		
		CustomerDAOImpl cdao = new CustomerDAOImpl();
		Scanner scan = new Scanner(System.in);
		Connection con = null;
		CallableStatement ct = null;	// 저장 프로시저 호출 실행
		String sql = null;
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, pwd);
			System.out.println("##### 저장 프로시저 수행 실습 #####");
			System.out.print("고객 번호 입력 >> ");
			int cus_no = Integer.parseInt(scan.nextLine());
			CustomerDTO cusNo = cdao.getCus_No(cus_no);
			
			if(cusNo == null) {
				System.out.println("고객번호가 없어서 저장 프로시저를 수행하지 못합니다.");
			} else {
				sql = "{call customer_pro(?,?,?,?)}";
				ct = con.prepareCall(sql);	// 저장 프로시저를 호출해서 수행할 ct 생성
				ct.setInt(4, cus_no);
				
				// 쿼리문의 첫번째 물음표에 오라클로부터 받아올 값에 대한 타입을 지정
				ct.registerOutParameter(1, java.sql.Types.VARCHAR);
				ct.registerOutParameter(2, java.sql.Types.VARCHAR);
				ct.registerOutParameter(3, java.sql.Types.VARCHAR);
				
				ct.execute();	// 저장 프로시저 실행
				
				System.out.println("고객번호 \t 고객이름 \t 고객폰번호 \t 고객이메일");
				System.out.println("=====================================");
				System.out.println(cus_no + "\t" + ct.getString(1) + "\t"
									+ ct.getString(2) + "\t" + ct.getString(3));
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(ct != null) ct.close();
				if(con != null) con.close();
				if(scan != null) scan.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
}
