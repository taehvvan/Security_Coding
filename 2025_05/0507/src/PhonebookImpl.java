import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PhonebookImpl implements PhonebookInter {

	// Phonebook[] array;
	// String[] sArray;
	// List<Phonebook> list = new ArrayList<Phonebook>();
	List<Phonebook> list;
	
	public PhonebookImpl() {
		list = new ArrayList<Phonebook>();
	}
	
	
	@Override
	public int insert(String name, String hp, String email) {
		// 어떤 상황일 때 오류가 발생하는지 확인
		
		// 입력값 중 하나 이상이 null값일 때 오류 발생
		if(name == null || hp == null || email == null) {
			System.out.println("입력값 중 null값 발생하여 중지");
			return 0;
		}
		
		// 입력한 값이 정규식에 일치하지 않을 때 오류 발생
		String regex = "^010-\\d{4}-\\d{4}$";	// 정규식
        if (!hp.matches(regex)) {
            System.out.println("유효한 전화번호가 아닙니다.");
            return 0;
        }
		
		// 오류 발생할 때 리턴값을 0, 그렇지 않으면 1
		Phonebook pb = new Phonebook(name, hp, email);
		list.add(pb);
		return 1;
	}

	@Override
	public List<Phonebook> findAll() {
		return list;
	}

	
	// 한 명 찾기
	@Override
	public Phonebook findByHp(String hp) {
		for(Phonebook pb : list) {
			if(pb.getHp().equals(hp)) {
				return pb;
			}
		}
		return null;
	}
	
	// 여러 명 찾기
	public List<Phonebook> findByName(String name) {
		List<Phonebook> findList = new ArrayList<Phonebook>();
		for(Phonebook pb : list) {
			if(pb.getName().equals(name)) {
				findList.add(pb);
			}
		}
		return findList;
	}
	
	@Override
	public Phonebook findByEmail(String email) {
		for(Phonebook pb : list) {
			if(pb.getEmail().equals(email)) {
				return pb;
			}
		}
		return null;
	}

	@Override
	public int update(String email, String name, String hp) {
		Phonebook pb = findByEmail(email);
	    if (pb != null) {
	        pb.setName(name);
	        pb.setHp(hp);
	        return 1;
	    }
	    return 0;
    }

	@Override
	public int delete(String email) {
		Phonebook pb = findByEmail(email);
	    if (pb != null) {
	        list.remove(pb);
	        return 1;
	    }
	    return 0;
	}


	public int menu() {
		System.out.println("=======MENU=======");
		System.out.println("1. 전화번호부 입력");
		System.out.println("2. 전화번호부 전체 출력");
		System.out.println("3. 전화번호부 선택 출력");
		System.out.println("4. 전화번호부 수정");
		System.out.println("5. 전화번호부 삭제");
		System.out.println("==================");
		System.out.print("메뉴를 선택하세요 >> ");
		
		int sel = new Scanner(System.in).nextInt();
		return sel;
	}

}
