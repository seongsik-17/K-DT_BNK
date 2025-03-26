package vo;

public class Human {
	// 이름과 나이를 부여받음
	// 아무런 정보 없이 데이터 존재 가능
	// 생성된 후 사람은 이름과 나이를 부여받는다.
	// 이때 나이는 1살 부터 200살 사이의 값이어야 한다.
	// 만일 나이를 부여할 떄 범위 밖의 값이 부여된다면 '값의 허용범위를 벗어났어요'라는 메세지를 출력
	// 그리고 나이는 0살 세팅
	// 사람은 이름과 나이를 부여받아 생성될 수도 있어야 합니다.
	private String name;
	private int age;

	public Human() {
		// 기본 생성자 생성.
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		if (age < 1 || age > 199) {
			System.out.println("값의 범위를 벗어났어요.");
			age = 0;
		}
		this.age = age;

	}

	public void cheakAge(int age) {
		if (age < 1 || age > 199) {
			System.out.println("값의 범위를 벗어났어요.");
		}
		System.out.println("age는 사용 가능한 범위입니다.");

	}

	@Override
	public String toString() {
		if (age == 0) {
			return "Human [name=" + name + ", age= 미정" + "]";
		}
		return "Human [name=" + name + ", age=" + age + "]";
	}

}
