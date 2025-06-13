import java.util.Scanner;

public class PhonebookMain {

	public static void main(String[] args) {
		
		PhonebookImpl pbfunc = new PhonebookImpl();
		
		while(true) {
			switch(pbfunc.menu()) {
				case 1 : 
					System.out.print("전화번호부에 사용할 이름을 입력하세요.");
					String name = new Scanner(System.in).nextLine();
					System.out.print("전화번호부에 사용할 전화번호를 입력하세요.");
					String hp = new Scanner(System.in).nextLine();
					System.out.print("전화번호부에 사용할 이메일을 입력하세요.");
					String email = new Scanner(System.in).nextLine();
					pbfunc.insert(name, hp, email);
					break;
				case 2 :
					System.out.println("=========================================");
					System.out.println("|  이 름  |     전화번호     |     이메일     |");
					System.out.println("=========================================");
					for(Phonebook pb : pbfunc.findAll()) {
						System.out.println("| " + pb.getName() + "  | " + pb.getHp() + " | " + pb.getEmail() + " |");
						System.out.println("=========================================");
					}
					break;
				case 3 :
					System.out.println("전화번호를 검색하여 이름 찾기");
					System.out.print("전화번호를 입력하세요 >> ");
					String searchHp = new Scanner(System.in).nextLine();
					Phonebook pb = pbfunc.findByHp(searchHp);
					System.out.println("이름 : " + pb.getName());
					System.out.println("전화번호 : " + pb.getHp());
					System.out.println("이메일 : " + pb.getEmail());
					break;
				case 4 :
					System.out.println("이메일을 기준으로 정보 수정하기");
				    System.out.print("수정할 이메일을 입력하세요 >> ");
				    String updateEmail = new Scanner(System.in).nextLine();
				    
				    Phonebook pb1 = pbfunc.findByEmail(updateEmail);
				    if (pb1 != null) {
				        System.out.print("새 이름을 입력하세요 >> ");
				        String newName = new Scanner(System.in).nextLine();
				        System.out.print("새 전화번호를 입력하세요 >> ");
				        String newHp = new Scanner(System.in).nextLine();

				        pbfunc.update(updateEmail, newName, newHp);
				        System.out.println("수정이 완료되었습니다.");
				    } else {
				        System.out.println("해당 이메일을 가진 사용자를 찾을 수 없습니다.");
				    }
				    break;
				case 5 :
					System.out.println("이메일을 입력해 정보를 삭제합니다.");
				    System.out.print("삭제할 이메일을 입력하세요 >> ");
				    String deleteEmail = new Scanner(System.in).nextLine();

				    Phonebook pb2 = pbfunc.findByEmail(deleteEmail);
				    if (pb2 != null) {
				        pbfunc.delete(deleteEmail);
				        System.out.println("삭제가 완료되었습니다.");
				    } else {
				        System.out.println("해당 이메일을 가진 사용자를 찾을 수 없습니다.");
				    }
				    break;
			}
		}
	}

}
