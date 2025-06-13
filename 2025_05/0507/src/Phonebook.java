// VO (Value Object) 객체

public class Phonebook {
	private String name;
	private String hp;
	private String email;
	
	// 기본생성자, 필드생성자, get함수, set함수, toString함수
	
	// 기본생성자
	public Phonebook() {}

	// 필드생성자
	public Phonebook(String name, String hp, String email) {
		super();
		this.name = name;
		this.hp = hp;
		this.email = email;
	}

	// get, set 함수
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHp() {
		return hp;
	}

	public void setHp(String hp) {
		this.hp = hp;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	// toString 함수
	@Override
	public String toString() {
		return "Phonebook [name=" + name + ", hp=" + hp + ", email=" + email + "]";
	}
	
	
	
	
}
