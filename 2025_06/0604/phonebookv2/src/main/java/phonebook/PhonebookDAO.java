package phonebook;

import java.util.List;

public interface PhonebookDAO {
	
		// 입력
		public int insert(Phonebook pb);
		
		// 전체 출력
		public List<Phonebook> findAll();
		
		// 선택 출력
		public Phonebook findById(int id);
		
		// 수정
		public int updateById(Phonebook pb);
		
		// 삭제
		public int deleteById(int id);

}
