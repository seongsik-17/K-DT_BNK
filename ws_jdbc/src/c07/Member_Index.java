package c07;
enum Gender{
	MALE, FEMALE
}
public class Member_Index {

	public static void main(String[] args) {
		Member m = new Member();
		m.setName("홍길동");
		m.setGender(Gender.FEMALE);
		
		
		switch(m.getGender()) {
		case MALE -> System.out.println("이름>> "+m.getName()+" 남자회원");
		case FEMALE -> System.out.println("이름>> "+m.getName()+" 여자회원");
		}

	}

}
