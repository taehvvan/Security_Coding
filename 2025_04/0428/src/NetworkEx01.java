// www.naver.com 이라는 도메인을 가진 웹사이트 주소를 입력하면 이 주소에 대한 IP 주소를 알아내는 예제

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class NetworkEx01 {

	public static void main(String[] args) throws Exception {

		BufferedReader reader;
		String url = null;
		InetAddress addr = null;	// IP 번호를 처리할 때 사용하는 클래스
		
		reader = new BufferedReader(new InputStreamReader(System.in));
		/*
		 * 1. System.in : 키보드 입력장치와 연결
		 * 2. InputStreamReader : 읽어들인 바이트 스트림을 문자 스트림으로 변경
		 * 3. BufferedReader : 읽어들인 문자를 임시메모리에 버퍼링하여 한 줄 문자열을 통으로 읽어들임
		 */
		
		System.out.print("사이트 주소를 입력(www.naver.com) >> ");
		url = reader.readLine();	// 한 줄 끝까지 문자열로 읽어들임
		
		try {
			addr = InetAddress.getByName(url);	// 인자값으로 지정된 url에 대한 InetAddress 객체를 반환
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		
		System.out.println("\n ======================= \n");
		System.out.println(url + "에 대한 IP 주소 번호 : " + addr.getHostAddress());
		
	}

}
