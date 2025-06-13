import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Test_Insert {

	public static void main(String[] args) {
		
	String driver = "oracle.jdbc.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521";	
	String user = "night";
	String password = "night";
	
	Connection con = null;
	PreparedStatement pt = null;
	String sql = null;
	
	try {
		Class.forName(driver);
		con = DriverManager.getConnection(url, user, password);
		Scanner scan = new Scanner(System.in);
		System.out.println(">>>>> tbl_board7 테이블에 레코드 저장하기 <<<<<");
		System.out.print("작성자 >> ");
		String bname = scan.nextLine();
		System.out.print("글 제목 >> ");
		String btitle = scan.nextLine();
		System.out.print("글 내용 >> ");
		String bcont = scan.nextLine();
		
		sql = "insert into tbl_board7 (bno, bname, btitle, bcont, bdate) values(bno_seq2.nextval, ?, ?, ?, sysdate)";
		pt = con.prepareStatement(sql);
		pt.setString(1, bname);
		pt.setString(2, btitle);
		pt.setString(3, bcont);
		
		int re = pt.executeUpdate();
		
		if(re == 1) {
			System.out.println("게시글 저장 성공");
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
