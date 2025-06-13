// 멀티스레드 기능이 없는 네트워크 클라이언트 프로그램

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class EchoClientEx {
	Socket client = null;	// 서버와 통신하기 위한 소캣
	String ip = null;		// 서버 IP 주소를 저장하기 위한 변수
	static final int PORT = 7000;	// 서버와 동일한 포트번호를 지정
	
	Scanner scan = null;
	
	InputStream is;
	ObjectInputStream ois;	// 입력 스트림
	
	OutputStream os;
	ObjectOutputStream oos;	// 출력 스트림
	
	String sendData;	// 서버로 보낼 메시지를 저장할 변수
	String receiveData;	// 서버에서 받은 메시지를 저장할 변수
	
	public EchoClientEx(String ip) {
		this.ip = ip;
		
		try {
			System.out.println("###### 클라이언트 채팅 프로그램 ######");
			client = new Socket(ip, PORT);	// 사용자 소켓 생성 -> 서버 접속이 이루어지는 경우
			scan = new Scanner(System.in);
			
			os = client.getOutputStream();
			oos = new ObjectOutputStream(os);
			
			is = client.getInputStream();
			ois = new ObjectInputStream(is);
			
			System.out.print("데이터 입력 >> ");
			
			while((sendData = scan.nextLine()) != null) {
				oos.writeObject(sendData);	// 서버로 전송
				oos.flush();
				
				if(sendData.equals("exit")) {
					break;
				}
				receiveData = (String)ois.readObject();	// 서버로부터 전송받은 메시지를 저장
				System.out.println(client.getInetAddress() + "로부터 전송받은 메시지 : " + receiveData);
				System.out.print("입력 >> ");
			}
		} catch(Exception e) {
			e.printStackTrace();
			System.exit(0);
		} finally {
			try {
				if(ois != null) ois.close();
				if(is != null) is.close();
				if(oos != null) oos.close();
				if(os != null) os.close();
				if(client != null) client.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	} // 생성자 오버로딩
	public static void main(String[] args) {
		new EchoClientEx("172.16.15.81");	// 생성자 인자값으로 서버 IP 주소를 지정
										// localhost : 모든 내자신 컴퓨터를 의미하는 호스트 이름
		
	}

}
